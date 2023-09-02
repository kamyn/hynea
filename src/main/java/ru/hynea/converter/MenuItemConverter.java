package ru.hynea.converter;

import org.springframework.stereotype.Component;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.Ingredient;
import ru.hynea.model.MenuItem;
import ru.hynea.model.MenuItemIngredient;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemConverter {
    public static MenuItemDto toDto(MenuItem menuItem) {
        StringBuilder sb = new StringBuilder();
        for (MenuItemIngredient ing : menuItem.getIngredientsList()) {
            sb.append(ing.getIngredient().getTitle());
            sb.append(" : ");
            sb.append(ing.getIngredient().getDosage());
            sb.append("\n");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        String ingredients = sb.toString();

        return new MenuItemDto(menuItem.getId(), menuItem.getTitle(),
                menuItem.getServe_time(), menuItem.getWeight(), menuItem.getPrice(),
                ingredients, menuItem.getImage_name());
    }

    public static MenuItem toMenuItem(MenuItemDto menuItemDto) {
        MenuItem menuItem = new MenuItem();

        menuItem.setId(menuItemDto.getId());
        menuItem.setTitle(menuItemDto.getTitle());
        menuItem.setPrice(menuItemDto.getPrice());
        menuItem.setServe_time(menuItemDto.getServeTime());
        menuItem.setWeight(menuItemDto.getWeight());
        menuItem.setImage_name(menuItemDto.getImageName());

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
