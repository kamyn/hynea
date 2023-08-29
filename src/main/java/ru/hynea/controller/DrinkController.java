package ru.hynea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hynea.model.Drink;
import ru.hynea.service.DrinkService;

import java.util.List;

@Controller
public class DrinkController {
    private final DrinkService drinkService;
    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/drinks")
    public String getDrinks(Model model) {
        List<Drink> drinksList = drinkService.findAll();
        model.addAttribute("drinksList", drinksList);
        return "drink-list";
    }
}
