package ru.hynea.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.hynea.dto.BreakfastItemDto;
import ru.hynea.dto.MenuItemDto;
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
@RequiredArgsConstructor
public class MenuUpdateController {

    private final MenuItemService menuItemService;

    @Value("${images.path}")
    private String imagesPath;

    @GetMapping("/menu-panel")
    public String menuList(Model model) {
        List<MenuItemDto> menuItemList = menuItemService.findAll();
        model.addAttribute("menuItems", menuItemList);
        model.addAttribute("newMenuItem", new MenuItemDto());
        model.addAttribute("newBreakfastItem", new BreakfastItemDto());
        return "menu-panel";
    }

    @PostMapping("/menu-create")
    public String addMenuItem(MenuItemDto newMenuItem,
                              @RequestParam MultipartFile image) throws IOException {

        if (image != null) {
            File imageDir = new File(imagesPath);
            if (!imageDir.exists()) {
                imageDir.mkdir();
            }
            String uuid = UUID.randomUUID().toString();
            String imageName = uuid + '.' + image.getOriginalFilename();
            newMenuItem.setImageName(imageName);
            image.transferTo(new File(imagesPath + "/" + imageName));
        }
        menuItemService.saveMenuItem(newMenuItem);
        return "redirect:/menu-panel";
    }

    @PostMapping("/menu-delete")
    public String deleteMenuItem(@RequestParam Long menuItemId) {
        menuItemService.deleteById(menuItemId);
        return "redirect:/menu-panel";
    }

    @PostMapping("/menu-update-request")
    public String updateMenuItemRequest(@RequestParam Long updateMenuItemId,
                                        Model model) {
        List<MenuItemDto> menuItemList = menuItemService.findAll();
        model.addAttribute("menuItems", menuItemList);
        model.addAttribute("newMenuItem", new MenuItemDto());
        model.addAttribute("newBreakfastItem", new BreakfastItemDto());

        MenuItemDto menuItem = menuItemService.findById(updateMenuItemId);
        model.addAttribute("updateMenuItem", menuItem);
        return "/menu-panel";
    }

    @PostMapping("/menu-update")
    public String updateMenuItem(MenuItemDto updateMenuItem) {
        menuItemService.saveMenuItem(updateMenuItem);
        return "redirect:/menu-panel";
    }
}
