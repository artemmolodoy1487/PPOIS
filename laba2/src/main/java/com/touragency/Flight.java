package com.touragency;

public class Flight extends Transport {
    private String airline;

    public Flight(String airline, int capacity) {
        super("Flight", capacity);
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }
}
