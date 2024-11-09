package by.starovoitov.shop.logic;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Client extends Men {

    private Wallet wallet; // Поле для инкапсуляции

    // Конструктор для создания клиента
    public Client(String email, String name, Wallet wallet) {
        super(email, name); // Вызов конструктора родительского класса
        this.wallet = wallet;
    }

    // Конструктор по умолчанию


    // Конструктор для создания клиента из JSON по адресу
    public static Client loadFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), Client.class);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void saveToJsonFile(String file_path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Запись клиента в JSON файл (перезапись, если файл существует)
        objectMapper.writeValue(new File(file_path), this);
    }
}