package by.starovoitov.touragency;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private String name;
    private List<Tour> tours;

    public Agency(String name) {
        this.name = name;
        this.tours = new ArrayList<>();
    }

    public void addTour(Tour tour) {
        tours.add(tour);
    }

    public List<Tour> getTours() {
        return tours;
    }

    public String getName() {
        return name;
    }
}
