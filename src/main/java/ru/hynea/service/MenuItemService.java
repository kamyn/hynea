package ru.hynea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.model.Ingredient;
import ru.hynea.model.MenuItem;
import ru.hynea.model.MenuItemIngredient;
import ru.hynea.repository.MenuItemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem findById(Long id) {
        return menuItemRepository.getOne(id);
    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem setIngredients(MenuItem menuItem, String ingredients) {
        HashMap<String, Integer> ingredientMap = new HashMap<>();

        String[] lines = ingredients.split("\n");
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String ingredient = parts[0].trim();
                int dosage = Integer.parseInt(parts[1].trim());
                ingredientMap.put(ingredient, dosage);
            }
        }

        menuItem.setIngredientsList(new ArrayList<>());

        for (var entry : ingredientMap.entrySet()) {
            var newIngredient = new Ingredient();
            newIngredient.setTitle(entry.getKey());
            newIngredient.setDosage(entry.getValue());

            var newMenuItemIngredient = new MenuItemIngredient();
            newMenuItemIngredient.setIngredient(newIngredient);
            newMenuItemIngredient.setMenuItem(menuItem);

            menuItem.getIngredientsList().add(newMenuItemIngredient);
        }
        return menuItem;
    }
}
