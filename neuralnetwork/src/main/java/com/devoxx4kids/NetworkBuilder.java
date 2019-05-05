package com.devoxx4kids;

import com.devoxx4kids.marioworld.Nintanco;
import com.devoxx4kids.species.DefaultMutationConfiguration;
import com.devoxx4kids.species.MutationConfiguration;
import com.devoxx4kids.species.SingleNetwork;
import com.devoxx4kids.species.node.*;
import com.devoxx4kids.species.node.serializationmodel.Container;
import com.devoxx4kids.species.node.serializationmodel.SerializedConnection;
import com.devoxx4kids.species.node.serializationmodel.SerializedNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NetworkBuilder {

    static private Random random = new Random();


    public static SingleNetwork fromTwoParents(SingleNetwork parentOne, SingleNetwork parentTwo, MutationConfiguration mutationConfiguration) {

        // make sure parent1 always has the higher fitness
        if (parentOne.getFitness() < parentTwo.getFitness()) {
            SingleNetwork temp = parentOne;
            parentOne = parentTwo;
            parentTwo = temp;
        }

        List<Node> childNodes = new ArrayList(parentOne.getNodes());
        List<Connection> connections = new ArrayList<>();

        Consumer<Connection> addToList = x -> {
            connections.add(x);

            if (!childNodes.contains(x.getInput())) {
                childNodes.add(x.getInput());
            }

            if (!childNodes.contains(x.getOutput())) {
                childNodes.add(x.getOutput());
            }
        };

        getConnections(parentOne, parentTwo, addToList);
        SingleNetwork singleNetwork = new SingleNetwork(childNodes, connections);
        singleNetwork.mutate(mutationConfiguration);
        return singleNetwork;
    }

    public static SingleNetwork getNewInstance() {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 14; j++) {
                nodes.add(new BlockNode(i, j, 0));
            }
        }

        for (int button : Nintanco.buttons) {
            nodes.add(new OutputNode(button));
        }
        SingleNetwork singleNetwork = new SingleNetwork(nodes, new ArrayList<>());
        singleNetwork.mutate(DefaultMutationConfiguration.getInstance());
        return singleNetwork;
    }

    public static SingleNetwork fromJSON(String xml) {
        ObjectMapper om = new ObjectMapper();
        Container container;
        try {
            container = om.readValue(xml, Container.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

        Map<String, Connection> iDConnections = new HashMap<>();
        Map<String, Node> idToNodes = new HashMap<>(Arrays.stream(BUTTON.values())
                .map(e -> new OutputNode(e.getValue()))
                .collect(Collectors.toMap(OutputNode::getID, Function.identity())));

        IntStream.range(0, 15).boxed()
                .flatMap(y -> IntStream.range(0, 14)
                        .mapToObj(x -> new BlockNode(x,y, 0)))
                .forEach(blockNode -> idToNodes.put(blockNode.getID(), blockNode));

        container.getHiddenNodes().stream().forEach(node -> {
                    Node nodeToAdd = idToNodes.get(node.getId());
                    if (nodeToAdd == null) {
                        nodeToAdd = new HiddenNode(1, node.getId());
                        idToNodes.put(node.getId(), nodeToAdd);
                    }

                    Node finalNodeToAdd = nodeToAdd;
                    node.getInputNodes().stream().forEach(connection ->
                            generateConnection(iDConnections, idToNodes, node, finalNodeToAdd, connection, true)
                    );

                    node.getOutputNodes().stream().forEach(connection ->
                            generateConnection(iDConnections, idToNodes, node, finalNodeToAdd, connection, false)
                    );
                }
        );

        return new SingleNetwork(new ArrayList<>(idToNodes.values()), new ArrayList<>(iDConnections.values()));

    }

    private static void generateConnection(Map<String, Connection> iDConnections, Map<String, Node> idToNodes,
                                           SerializedNode node, Node nodeToAdd, SerializedConnection connection, boolean isInput) {
        Node connectingNode = idToNodes.get(connection.getId());
        if (connectingNode == null) {
            connectingNode = new HiddenNode(1, connection.getId());
            idToNodes.put(connectingNode.getID(), connectingNode);
        }

        String connectionID = isInput ? connectingNode.getID() + node.getId() : node.getId() + connectingNode.getID();
        if (!iDConnections.containsKey(connectionID)) {

            iDConnections.put(connectionID, isInput ? new Connection(connectingNode, nodeToAdd, connection.getWeight()) :
                    new Connection(nodeToAdd, connectingNode, connection.getWeight()));
        }
    }

    public static SingleNetwork copyFromNetwork(SingleNetwork copyFrom, boolean copyId) {
        List<Node> nodes = new ArrayList<>(copyFrom.getNodes());
        List<Connection> connections = copyFrom.getConnections().stream().map(Connection::copy).collect(Collectors.toList());
        return copyId ? new SingleNetwork(nodes, connections, copyFrom.getId()) : new SingleNetwork(nodes, connections);
    }

    public static void getConnections(SingleNetwork parentOne, SingleNetwork parentTwo, Consumer<Connection> addToList) {
        outer:
        for (Connection connection1 : parentOne.getConnections()) {
            for (Connection connection2 : parentTwo.getConnections()) {
                if (connection1.getInnovation() == connection2.getInnovation()) {
                    Connection connection = connection1.copy();
                    if (random.nextBoolean()) {
                        connection.setWeight(connection2.getWeight());
                    }
                    addToList.accept(connection);

                    continue outer;
                }
            }
            addToList.accept(connection1);
        }
    }
}
