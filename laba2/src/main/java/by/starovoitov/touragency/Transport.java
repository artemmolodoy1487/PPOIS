package by.starovoitov.touragency;

public class Transport {
    private String type;
    private int capacity;

    public Transport(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}
