package ru.hynea.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hynea.dto.BreakfastItemDto;
import ru.hynea.model.Breakfast;
import ru.hynea.model.Drink;
import ru.hynea.service.BreakfastService;
import ru.hynea.service.DrinkService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BreakfastController {

    private final BreakfastService breakfastService;

    @GetMapping("/breakfasts")
    public String getBreakfasts(Model model) {
        List<BreakfastItemDto> breakfastsList = breakfastService.findAll();
        model.addAttribute("menuItems", breakfastsList);
        return "menu";
    }

    @GetMapping("/breakfast")
    public String getItemDescription(@RequestParam Long id,
                                     Model model) {
        var breakfastItemDto = breakfastService.findById(id);
        model.addAttribute("breakfast", breakfastItemDto);
        return "breakfast-item";
    }
}
