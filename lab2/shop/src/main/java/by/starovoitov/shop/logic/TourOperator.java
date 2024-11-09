package by.starovoitov.shop.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TourOperator {
    private Wallet wallet;
    private List<TourPackage> tourPackages; // Список путевок

    public TourOperator(Wallet wallet) {
        this.wallet = wallet;
        this.tourPackages = new ArrayList<>(); // Инициализация списка путевок
        loadToursFromJson("/home/artem/Рабочий стол/shop/src/main/java/by/starovoitov/shop/logic/tours.json");
    }

    public void printTourPackages() {
        if (tourPackages.isEmpty()) {
            System.out.println("No available tours.");
            return;
        }

        System.out.println("Available Tours:");
        for (TourPackage tourPackage : tourPackages) {
            System.out.printf("Destination: %s, Price: %d%n", tourPackage.getPlace(), tourPackage.getPrice().getAmount());
        }
    }

    public void addTourPackage(TourPackage tourPackage) {
        tourPackages.add(tourPackage); // Добавление путевки в список
    }

    public List<TourPackage> getTourPackages() {
        return tourPackages; // Получение списка путевок
    }

    public Wallet getWallet() {
        return wallet; // Получение кошелька
    }

    // Метод для загрузки путевок из JSON файла
    private void loadToursFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Чтение массива объектов из файла
            JsonNode tourArray = objectMapper.readTree(new File(filePath));
            for (JsonNode node : tourArray) {
                String place = node.get("place").asText();
                int price = node.get("price").asInt();
                Money tourPrice = new Money(price); // Предполагаем, что у вас есть конструктор в Money
                TourPackage tourPackage = new TourPackage(place, tourPrice);
                addTourPackage(tourPackage); // Добавляем путевку в список
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}