package by.starovoitov.shop;

import by.starovoitov.shop.logic.Client;
import by.starovoitov.shop.logic.Wallet;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Register {

    @PostMapping("/register")
    public Map<String, String> register(@RequestParam String name, @RequestParam String email) throws IOException {
        Client me = new Client(email, name, new Wallet(1000));
        me.saveToJsonFile("/home/artem/Рабочий стол/shop/src/main/java/by/starovoitov/shop/logic/client.json");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Клиент зарегистрирован");
        response.put("name", me.getName());
        response.put("email", me.getEmail());
        response.put("balance", String.valueOf(me.getWallet().getMoney().getAmount()));
        response.put("credit", String.valueOf(me.getWallet().getCredit().getAmount()));

        return response;
    }
}