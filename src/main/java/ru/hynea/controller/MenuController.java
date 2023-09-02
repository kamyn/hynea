package ru.hynea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.MenuItem;
import ru.hynea.service.MenuItemService;

import java.util.List;

@Controller
public class MenuController {
    private final MenuItemService menuItemService;
    @Autowired
    public MenuController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/")
    public String main(Model model) {
        List<MenuItemDto> menuItemList = menuItemService.findAll();
        model.addAttribute("menuItems", menuItemList);
        return "menu";
    }
}
