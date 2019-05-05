package com.devoxx4kids.species.node.serializationmodel;


public class SerializedConnection {

    private String id;

    private Double weight;

    public SerializedConnection() {
    }

    public SerializedConnection(String id, Double weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
