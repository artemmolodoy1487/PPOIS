package com.touragency;

public class Cruise extends Transport {
    private String shipName;

    public Cruise(String shipName, int capacity) {
        super("Cruise", capacity);
        this.shipName = shipName;
    }

    public String getShipName() {
        return shipName;
    }
}
