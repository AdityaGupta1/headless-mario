package com.devoxx4kids.species.node;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.devoxx4kids.Constants.*;

public class Comparators {
    private static TreeMap<Integer, boolean[]> compareConnections(List<Connection> connectionsOne, List<Connection> connectionTwo) {
        Set<Integer> innovations = Stream.of(connectionsOne, connectionTwo).flatMap(List::stream).map(Connection::getInnovation).collect(Collectors.toSet());

        TreeMap<Integer, boolean[]> comparison = new TreeMap<>();
        for (int innovation : innovations) {
            boolean[] has = new boolean[2];
            Arrays.fill(has, false);

            for (Connection connection : connectionsOne) {
                if (connection.getInnovation() == innovation) {
                    has[0] = true;
                }
            }

            for (Connection connection : connectionTwo) {
                if (connection.getInnovation() == innovation) {
                    has[1] = true;
                }
            }

            comparison.put(innovation, has);
        }

        return comparison;
    }



    private static int[] countNonMatching(List<Connection> connectionsOne, List<Connection> connectionTwo) {
        if(connectionsOne.isEmpty() || connectionTwo.isEmpty()) {
            return new int[0];
        }
        TreeMap<Integer, boolean[]> comparison = Comparators.compareConnections(connectionsOne,connectionTwo);

        boolean[] last = comparison.get(new ArrayList<>(comparison.descendingKeySet()).get(0));

        int excess = 0;

        outer:
        if (!Arrays.equals(last, new boolean[]{true, true})) {
            for (int innovation : comparison.descendingKeySet()) {
                if (Arrays.equals(comparison.get(innovation), last)) {
                    excess++;
                } else {
                    break outer;
                }
            }
        }

        int disjoint = 0; // includes excess until return statement
        for (boolean[] has : comparison.values()) {
            if (!Arrays.equals(has, new boolean[]{true, true})) {
                disjoint++;
            }
        }

        return new int[]{disjoint - excess, excess};
    }


    private static double getAverageWeightDistance(List<Connection>connectionsOne, List<Connection> connectionTwo) {
        double distance = 0;
        int count = 0;

        outer:
        for (Connection connection :connectionsOne) {
            for (Connection otherConnection : connectionTwo) {
                if (connection.getInnovation() == otherConnection.getInnovation()) {
                    distance += Math.abs(connection.getWeight() - otherConnection.getWeight());
                    count++;
                    continue outer;
                }
            }
        }

        if (count == 0) {
            return 0;
        } else {
            return distance / count;
        }
    }

     public static double getCompatibility(List<Connection> connectionsOne, List<Connection> connectionTwo) {
        int[] nonMatching = countNonMatching(connectionsOne, connectionTwo);
        return deltaDisjoint * nonMatching[0]
                + deltaExcess * nonMatching[1]
                + deltaWeights * getAverageWeightDistance(connectionsOne, connectionTwo);
    }


    public static boolean isCompatible(List<Connection> connectionsOne, List<Connection> connectionTwo) {
        return Comparators.getCompatibility(connectionsOne,connectionTwo) <= compatibilityThreshold;
    }

}
