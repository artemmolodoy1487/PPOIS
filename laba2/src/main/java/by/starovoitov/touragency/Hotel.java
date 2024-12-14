package by.starovoitov.touragency;

public class Hotel {
    private String name;
    private int stars;

    public Hotel(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }
}
