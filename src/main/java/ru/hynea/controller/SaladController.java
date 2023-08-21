package ru.hynea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hynea.model.Salad;
import ru.hynea.service.SaladService;

import java.util.List;

@Controller
public class SaladController {
    @Autowired
    private final SaladService saladService;
    public SaladController(SaladService saladService) { this.saladService = saladService;}

    @GetMapping("/salad")
    public String getSalads(Model model) {
        List<Salad> salads = saladService.findAll();
        model.addAttribute("items", salads);
        return "salad-list";
    }
}
