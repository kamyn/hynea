package ru.hynea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.model.MenuItem;
import ru.hynea.model.MenuItemIngredient;
import ru.hynea.repository.MenuItemIngredientRepository;
import java.util.List;
@Service
public class MenuItemIngredientService {
    @Autowired
    private final MenuItemIngredientRepository menuItemIngredientRepository;
    public MenuItemIngredientService(MenuItemIngredientRepository menuItemIngredientRepository) {
        this.menuItemIngredientRepository = menuItemIngredientRepository;
    }

    public List<MenuItemIngredient> findAll() {
        return menuItemIngredientRepository.findAll();
    }
}
