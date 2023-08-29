package ru.hynea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.hynea.model.Ingredient;
import ru.hynea.model.MenuItem;
import ru.hynea.service.MenuItemService;

import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MenuUpdateController {
    private final MenuItemService menuItemService;
    @Autowired
    public MenuUpdateController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @Value("${images.path}")
    private String imagesPath;

    @GetMapping("/menu-update")
    public String menuList(Model model) {
        List<MenuItem> menuItemList = menuItemService.findAll();
        model.addAttribute("menuItems", menuItemList);
        model.addAttribute("newMenuItem", new MenuItem());
        return "menu-update";
    }

    @PostMapping("/menu-create")
    public String addMenuItem(MenuItem newMenuItem,
                              @RequestParam String ingredients,
                              @RequestParam MultipartFile image) throws IOException {

        menuItemService.setIngredients(newMenuItem, ingredients);

        if (image != null) {
            File imageDir = new File(imagesPath);
            if (!imageDir.exists()) {
                imageDir.mkdir();
            }
            String uuid = UUID.randomUUID().toString();
            String imageName = uuid + '.' + image.getOriginalFilename();
            newMenuItem.setImage_name(imageName);
            image.transferTo(new File(imagesPath + "/" + imageName));
        }
        menuItemService.saveMenuItem(newMenuItem);
        return "redirect:/menu-update";
    }

    @PostMapping("/menu-delete")
    public String deleteMenuItem(@RequestParam Long menuItemId) {
        menuItemService.deleteById(menuItemId);
        return "redirect:/menu-update";
    }
}
