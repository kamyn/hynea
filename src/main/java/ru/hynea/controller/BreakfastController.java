package ru.hynea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hynea.model.Breakfast;
import ru.hynea.model.Drink;
import ru.hynea.service.BreakfastService;
import ru.hynea.service.DrinkService;

import java.util.List;

@Controller
public class BreakfastController {
    @Autowired
    private final BreakfastService breakfastService;
    public BreakfastController(BreakfastService breakfastService) {
        this.breakfastService = breakfastService;
    }

    @GetMapping("/breakfasts")
    public String getBreakfasts(Model model) {
        List<Breakfast> breakfastsList = breakfastService.findAll();
        model.addAttribute("breakfastsList", breakfastsList);
        return "breakfast-list";
    }
}
