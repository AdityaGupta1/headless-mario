package com.devoxx4kids.species;
import com.devoxx4kids.species.node.Comparators;

import java.util.ArrayList;
import java.util.List;

class Species implements Comparable<Species> {
    private final int id;
    private static int nextId = 0;

    private SingleNetwork representative;
    private final List<SingleNetwork> networks = new ArrayList<>();

    Species(SingleNetwork representative) {
        id = ++nextId;
        this.representative = representative;
        add(representative);
    }

    boolean add(SingleNetwork network) {
        if (Comparators.isCompatible(representative.getConnections(),network.getConnections())) {
            networks.add(network);
            network.setSpecies(id);
            return true;
        } else {
            return false;
        }
    }

    List<SingleNetwork> getNetworks() {
        return new ArrayList<>(networks);
    }

    public int getId() {
        return id;
    }

    int getSize() {
        return networks.size();
    }

    double getAdjustedFitness() {
        return  networks.stream().mapToInt(SingleNetwork::getFitness).average().orElse(0);
    }

    boolean notEmpty() {
        return !networks.isEmpty();
    }

    void reset() {
        representative = networks.get(0);
        networks.clear();
    }

    @Override
    public int compareTo(Species other) {
        return Double.compare(this.getAdjustedFitness(), other.getAdjustedFitness());
    }
}
