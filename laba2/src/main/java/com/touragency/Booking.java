package com.touragency;

public class Booking {
    private Client client;
    private Tour tour;

    public Booking(Client client, Tour tour) {
        this.client = client;
        this.tour = tour;
    }

    public String getDetails() {
        return client.getName() + " booked a tour to " + tour.getDestination();
    }
}
