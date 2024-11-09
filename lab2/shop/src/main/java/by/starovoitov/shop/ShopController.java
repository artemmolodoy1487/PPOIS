package by.starovoitov.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @GetMapping("/")  // Maps the root URL
    public String home() {
        return "index"; // This should correspond to index.html in templates
    }

    @GetMapping("/reg-client")  // Maps to registration for users
    public String regClient() {
        return "reg-client"; // This should correspond to reg-client.html in templates
    }

    @GetMapping("/reg-operator")  // Maps to registration for operators
    public String regOperator() {
        return "reg-operator"; // This should correspond to reg-operator.html in templates
    }

    @GetMapping("/list-of-tours")  // Maps to the list of operators
    public String listOfOperators() {
        return "list-of-tours"; // This should correspond to list-of-operators.html in templates
    }
}