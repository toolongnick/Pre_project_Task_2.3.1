package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(name = "count", required = false) Integer number, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Niva", 4, "white"));
        cars.add(new Car("Aveo", 2, "red"));
        cars.add(new Car("Astra", 2, "black"));
        cars.add(new Car("Shuttle", 7, "blue"));
        cars.add(new Car("Transporter", 8, "greenish"));
        if (number != null) {
            cars = cars.stream().limit(number).collect(Collectors.toList());
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}