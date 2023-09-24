package ru.hynea.converter;

import org.springframework.stereotype.Component;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.Ingredient;
import ru.hynea.model.MenuItem;
import ru.hynea.model.MenuItemIngredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MenuItemConverter {
    public MenuItemDto toDto(MenuItem menuItem) {
        if (menuItem != null) {
            String ingredients = menuItem.getIngredientsList()
                    .stream()
                    .map(ing -> ing.getIngredient().getTitle() + " : " + ing.getIngredient().getDosage())
                    .collect(Collectors.joining("\n"));
            return MenuItemDto.builder()
                    .id(menuItem.getId())
                    .title(menuItem.getTitle())
                    .serveTime(menuItem.getServeTime())
                    .weight(menuItem.getWeight())
                    .price(menuItem.getPrice())
                    .ingredients(ingredients)
                    .imageName(menuItem.getImageName())
                    .build();
        }
        return new MenuItemDto();
    }

    public MenuItem toMenuItem(MenuItemDto menuItemDto) {
        MenuItem menuItem = new MenuItem();

        menuItem.setId(menuItemDto.getId());
        menuItem.setTitle(menuItemDto.getTitle());
        menuItem.setPrice(menuItemDto.getPrice());
        menuItem.setServeTime(menuItemDto.getServeTime());
        menuItem.setWeight(menuItemDto.getWeight());
        menuItem.setImageName(menuItemDto.getImageName());

        List<MenuItemIngredient> ingredientList = new ArrayList<>();
        String[] lines = menuItemDto.getIngredients().split("\n");
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String ingredientName = parts[0].trim();
                int dosage = Integer.parseInt(parts[1].trim());

                Ingredient ingredient = new Ingredient();
                ingredient.setTitle(ingredientName);
                ingredient.setDosage(dosage);

                MenuItemIngredient menuItemIngredient = new MenuItemIngredient();
                menuItemIngredient.setIngredient(ingredient);
                menuItemIngredient.setMenuItem(menuItem);

                ingredientList.add(menuItemIngredient);
            }
        }

        menuItem.setIngredientsList(ingredientList);

        return menuItem;
    }
}
