package ru.hynea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.MenuItem;
import ru.hynea.service.DrinkService;
import ru.hynea.service.MenuItemService;
import ru.hynea.service.SaladService;

import java.util.List;

@Controller
public class MenuController {
    private final MenuItemService menuItemService;
    private final SaladService saladService;
    private  final DrinkService drinkService;
    @Autowired
    public MenuController(MenuItemService menuItemService,
                          SaladService saladService,
                          DrinkService drinkService) {
        this.menuItemService = menuItemService;
        this.saladService = saladService;
        this.drinkService = drinkService;
    }

    @GetMapping("/")
    public String getMenu(Model model) {
        List<MenuItemDto> menuItemList = menuItemService.findAll();
        model.addAttribute("menuItems", menuItemList);
        return "menu";
    }

    @GetMapping("/salads")
    public String getSalads(Model model) {
        List<MenuItemDto> salads = saladService.findAll();
        model.addAttribute("menuItems", salads);
        return "menu";
    }

    @GetMapping("/drinks")
    public String getDrinks(Model model) {
        List<MenuItemDto> drinks = drinkService.findAll();
        model.addAttribute("menuItems", drinks);
        return "menu";
    }

    @GetMapping("/menu")
    public String getItemDescription(@RequestParam Long id,
                                     Model model) {
        var menuItem = menuItemService.findById(id);
        model.addAttribute("menuItem", menuItem);
        return "menu-item";
    }
}
