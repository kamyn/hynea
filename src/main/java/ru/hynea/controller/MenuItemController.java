package ru.hynea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hynea.model.MenuItem;
import ru.hynea.model.User;
import ru.hynea.service.MenuItemService;

import java.util.List;

@Controller
public class MenuItemController {
    @Autowired
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/menu")
    public String findAll(Model model) {
        List<MenuItem> users = menuItemService.findAll();
        model.addAttribute("items", users);
        return "user-list";
    }
}
