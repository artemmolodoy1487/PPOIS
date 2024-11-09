package by.starovoitov.shop.logic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TourPackage {
    @JsonProperty("place")
    private String place; // Название места

    @JsonProperty("price")
    private Money price;  // Цена путевки

    public TourPackage(String place, Money price) {
        this.place = place;
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public Money getPrice() {
        return price;
    }
}