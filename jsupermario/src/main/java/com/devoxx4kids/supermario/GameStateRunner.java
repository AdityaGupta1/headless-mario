package com.devoxx4kids.supermario;

import com.devoxx4kids.supermario.mario.Enemy;
import com.devoxx4kids.supermario.mario.Player;
import com.devoxx4kids.supermario.mario.WorldWrapper;

import java.util.Objects;

public class GameStateRunner {


    private static final int ENEMY_MOVEMENT_SPEED = 1;
    private static final int SCREEN_VERTICAL_LIMIT = 230;
    private static final double HORIZONTAL_MOVE_PER_BUTTON = 0.037109;
    private static final double MAX_HORIZONTAL = 1.562;
    private static final double HORIZONAL_DECEL = 0.0507812;
    private static final double JUMP_ACCEL = 4.5;
    private static final int DOWN_ACC_LIMIT = -3;
    private static final double ENEMY_ACTIVATION_THRESHOLD = 150;
    private static final double HORIZONTAL_MIN_SPEED = 0.07421875;

    static GameState runGameStateSingleFrame(GameState gs, InputState is, WorldWrapper world) {
        Player player = gs.getPlayer();
        if (player.getBottomY() > SCREEN_VERTICAL_LIMIT) {
            player.kill();
            return gs;
        }

        handleEnemies(gs, world);
        handlePlayerHorizontalMovement(is, world, player);

        if (is.isJump() &&
                (world.get(player.getBottomY() + 1, player.getPlayerXPosition()) != 0
                        || world.get(player.getBottomY() + 1, player.getRightX()) != 0)
                && player.getVerticalAcc() == 0 && is.isPreviousJumpReleaesed()) {
            player.updateVerticalAcc(JUMP_ACCEL);
            player.setJumpSpeed();
            is.setPreviousJumpReleaesed(false);
        } else {
            player.setVerticalAcc(Math.max(DOWN_ACC_LIMIT, player.getVerticalAcc() - getFallRate(is.isJump(), player)));
        }
        if (player.getVerticalAcc() > 0) {

            for (int i = 1; i <= player.getVerticalAcc(); i++) {
                if (world.get(player.getPlayerYPosition() - 1, player.getPlayerXPosition()) != 0 ||
                        world.get(player.getPlayerYPosition() - 1, player.getRightX()) != 0) {
                    player.setVerticalAcc(0);
                    break;
                }
                player.verticalMove(-1);
            }

        } else if (player.getVerticalAcc() < 0) {
            for (int i = 1; i > player.getVerticalAcc(); i--) {
                if (world.get(player.getBottomY() + 1, player.getPlayerXPosition()) != 0 ||
                        world.get(player.getBottomY() + 1, player.getRightX()) != 0) {
                    player.setVerticalAcc(0);
                    if (!is.isJump())
                        is.setPreviousJumpReleaesed(true);
                    break;
                }
                player.verticalMove(1);
            }

        }

        if (player.getBottomY() > 230) {
            player.kill();
        }
        return gs;
    }

    private static double getFallRate(boolean isJumpPressed, Player p) {
        if (isJumpPressed) {
            if (p.getJumpSpeed() <= 1) {
                return 0.125;
            }
            if (p.getJumpSpeed() > 1) {
                return 0.1171875;
            }
        } else {
            if (p.getJumpSpeed() <= 1) {
                return 0.4375;
            }
            if (p.getJumpSpeed() > 1) {
                return 0.375;
            }
        }
        return 0.15625;
    }

    private static void handlePlayerHorizontalMovement(InputState is, WorldWrapper world, Player player) {
        if (is.isRigthPressed()) {
            player.setHorizontalAcc(Math.min(MAX_HORIZONTAL,
                    Math.max(HORIZONTAL_MIN_SPEED, HORIZONTAL_MOVE_PER_BUTTON + player.getHorizontalAcc())));
        } else if (is.isLeftPressed()) {
            player.setHorizontalAcc(Math.max(-MAX_HORIZONTAL,
                    Math.min(-HORIZONTAL_MIN_SPEED, -HORIZONTAL_MOVE_PER_BUTTON + player.getHorizontalAcc())));
        }

        if (player.getHorizontalAcc() > 0) {

            for (int i = 0; i < player.getHorizontalAcc(); i++) {
                if (world.get(player.getPlayerYPosition(), player.getRightX() + 1) == 0 &&
                        world.get(player.getBottomY(), player.getRightX() + 1) == 0) {
                    player.walk(1);
                }
            }
            if (!is.isRigthPressed()) {
                player.setHorizontalAcc(Math.max(0, player.getHorizontalAcc() - HORIZONAL_DECEL));
            }
        } else if (player.getHorizontalAcc() < 0) {
            for (int i = 0; i > player.getHorizontalAcc(); i--) {
                if (player.getPlayerXPosition() > 0 &&
                        world.get(player.getPlayerYPosition(), player.getPlayerXPosition() - 1) == 0
                        && world.get(player.getBottomY(), player.getPlayerXPosition() - 1) == 0) {
                    player.walk(-1);
                }
            }
            if (!is.isLeftPressed()) {
                player.setHorizontalAcc(Math.min(0, player.getHorizontalAcc() + HORIZONAL_DECEL));
            }
        }
    }

    private static void handleEnemies(GameState gs, WorldWrapper world) {
        Player player = gs.getPlayer();
        gs.getActiveEnemy().stream()
                .filter(e -> e.hasLandedOntop(player.getPlayerXPosition(), player.getPlayerYPosition(),
                        player.getVerticalAcc()) || e.getPosX() < 1
                ).forEach(e -> {
                    e.kill();
                    gs.getEnemiesToRemove().add(e);
                }
        );

        gs.getActiveEnemy().stream().filter(Objects::nonNull).forEach(enemy -> moveEnemy(world, enemy, gs));

        if (gs.getActiveEnemy().stream().anyMatch(enemy ->
                isCollision(player.getPlayerXPosition(), player.getPlayerYPosition(), enemy.getPosX(), enemy.posY()))) {
            player.kill();
        }

        gs.getInactiveEnemy().stream()
                .filter(e -> e.getPosX() - player.getPlayerXPosition() < ENEMY_ACTIVATION_THRESHOLD)
                .forEach(e -> {
                    gs.getActiveEnemy().add(e);
                    gs.getEnemiesToRemoveFromAdded().add(e);
                });

        gs.getActiveEnemy().removeAll(gs.getEnemiesToRemove());
        gs.getEnemiesToRemove().clear();
        gs.getInactiveEnemy().removeAll(gs.getEnemiesToRemoveFromAdded());
        gs.getEnemiesToRemoveFromAdded().clear();
    }

    private static void moveEnemy(WorldWrapper world, Enemy enemy, GameState gs) {

        for (int i = 0; i < ENEMY_MOVEMENT_SPEED; i++) {
            if (enemy.getPosX() - 1 < 0) {
                gs.getEnemiesToRemove().add(enemy);
                return;
            }
            if (world.get(enemy.bottomEdgeY() + 1, enemy.getPosX()) == 0 &&
                    world.get(enemy.bottomEdgeY() + 1, enemy.rightEdgeX()) == 0) {
                enemy.fall(1);
                if (enemy.bottomEdgeY() > SCREEN_VERTICAL_LIMIT - 1) {
                    gs.getEnemiesToRemove().add(enemy);
                    enemy.kill();
                    return;
                }
            } else {
                if (world.get(enemy.posY(),
                        (enemy.posX()) + (enemy.direction() == -1 ? -1 : Enemy.WIDTH + 1)) == 0) {
                    enemy.walk(enemy.direction());


                } else {
                    enemy.reverseDirection();
                }
            }
        }
    }

    private static boolean isCollision(double x1, double y1, double x2, double y2) {
        return x1 < x2 + 16 &&
                x1 + 16 > x2 &&
                y1 < y2 + 16 &&
                y1 + 16 > y2;
    }

}
