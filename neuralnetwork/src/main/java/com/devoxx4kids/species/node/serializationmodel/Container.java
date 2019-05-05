package com.devoxx4kids.species.node.serializationmodel;

import java.util.List;

public class Container {

    private List<SerializedNode> hiddenNodes;

    public List<SerializedNode> getHiddenNodes() {
        return hiddenNodes;
    }

    public void setHiddenNodes(List<SerializedNode> hiddenNodes) {
        this.hiddenNodes = hiddenNodes;
    }


}
