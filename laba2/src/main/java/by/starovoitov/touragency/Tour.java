package by.starovoitov.touragency;

public class Tour {
    private String destination;
    private int duration;
    private double price;

    public Tour(String destination, int duration, double price) {
        this.destination = destination;
        this.duration = duration;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }
}
