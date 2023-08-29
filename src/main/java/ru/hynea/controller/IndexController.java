package ru.hynea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hynea.model.MenuItem;
import ru.hynea.service.MenuItemService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private final MenuItemService menuItemService;
    public IndexController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/")
    public String main(Model model) {
        List<MenuItem> menuItemList = menuItemService.findAll();
        model.addAttribute("menuItems", menuItemList);
        return "index";
    }

    @GetMapping("/menu-item-add")
    public String addMenuItemForm(MenuItem menuItem) {
        return "menu-item-add";
    }

    @PostMapping("/menu-item-add")
    public String addMenuItem(MenuItem menuItem) {
        menuItemService.saveMenuItem(menuItem);
        return "redirect:/";
    }
}
