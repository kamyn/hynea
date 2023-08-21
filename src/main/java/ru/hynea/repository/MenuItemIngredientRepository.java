package ru.hynea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hynea.model.MenuItem;
import ru.hynea.model.MenuItemIngredient;

public interface MenuItemIngredientRepository extends JpaRepository<MenuItemIngredient, Long> {
}
