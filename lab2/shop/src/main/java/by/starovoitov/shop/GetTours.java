package by.starovoitov.shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api")
public class GetTours {

    @GetMapping("/get_tours")
    public String getTours() throws Exception {
        String filePath = "/home/artem/Рабочий стол/shop/src/main/java/by/starovoitov/shop/logic/tours.json";
        // Читаем содержимое файла и возвращаем его
        return Files.readString(Path.of(filePath));
    }
}