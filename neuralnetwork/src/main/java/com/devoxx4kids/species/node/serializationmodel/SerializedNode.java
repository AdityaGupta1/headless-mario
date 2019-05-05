package com.devoxx4kids.species.node.serializationmodel;

import java.util.ArrayList;
import java.util.List;

public class SerializedNode {
    private String id;
    private List<SerializedConnection> inputNodes = new ArrayList<>();
    private List<SerializedConnection> outputNodes = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SerializedConnection> getInputNodes() {
        return inputNodes;
    }

    public void setInputNodes(List<SerializedConnection> inputNodes) {
        this.inputNodes = inputNodes;
    }

    public List<SerializedConnection> getOutputNodes() {
        return outputNodes;
    }

    public void setOutputNodes(List<SerializedConnection> outputNodes) {
        this.outputNodes = outputNodes;
    }

    public void addInputConnection(SerializedConnection connection){
        inputNodes.add(connection);
    }

    public void addOutputConnection(SerializedConnection connection){
        outputNodes.add(connection);
    }
}
