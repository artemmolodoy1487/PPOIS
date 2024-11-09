package by.starovoitov.shop;

import by.starovoitov.shop.logic.Client;
import by.starovoitov.shop.logic.TourOperator;
import by.starovoitov.shop.logic.Transaction;
import by.starovoitov.shop.logic.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BuyTour {

    @PostMapping("/buy")
    public ResponseEntity<Map<String, Object>> buy(@RequestParam String place, @RequestParam int price) {
        Map<String, Object> response = new HashMap<>();

        try {
            TourOperator operator = new TourOperator(new Wallet(0));

            // Загрузка клиента из JSON
            Client client = new Client("eqe","dada",new Wallet(1000));

            // Проверка наличия средств
            if (client.getWallet().getMoney().getAmount() < price) {
                response.put("message", "Недостаточно средств для покупки.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            // Создание транзакции
            new Transaction(client.getWallet(), operator.getWallet(), price);

            // Обновление данных после транзакции
            client.saveToJsonFile("/home/artem/Рабочий стол/shop/src/main/java/by/starovoitov/shop/logic/client.json");

            // Формируем ответ
            response.put("message", "Покупка успешна!");
            response.put("balance", client.getWallet().getMoney().getAmount());
            response.put("credit", client.getWallet().getCredit().getAmount());

            return ResponseEntity.ok(response); // Возвращаем ответ
        } catch (IOException e) {
            e.printStackTrace();
            response.put("message", "Ошибка при работе с файлами: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Ошибка при обработке запроса: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}