package ru.hynea.converter.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.hynea.converter.MenuItemConverter;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.Ingredient;
import ru.hynea.model.MenuItem;
import ru.hynea.model.MenuItemIngredient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuItemConverterTest {

    @Mock
    private MenuItem menuItem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testToDto() {
        MenuItemIngredient ingredient1 = new MenuItemIngredient();
        Ingredient ingredient = new Ingredient();
        ingredient.setTitle("Ingredient 1");
        ingredient.setDosage(100);
        ingredient1.setIngredient(ingredient);
        ingredient1.setMenuItem(menuItem);

        Mockito.when(menuItem.getId()).thenReturn(1L);
        Mockito.when(menuItem.getTitle()).thenReturn("Test Menu Item");
        Mockito.when(menuItem.getServeTime()).thenReturn(15);
        Mockito.when(menuItem.getWeight()).thenReturn(200);
        Mockito.when(menuItem.getPrice()).thenReturn(10);
        Mockito.when(menuItem.getImageName()).thenReturn("item.jpg");
        Mockito.when(menuItem.getIngredientsList()).thenReturn(List.of(ingredient1));

        MenuItemDto menuItemDto = MenuItemConverter.toDto(menuItem);

        assertEquals(1L, menuItemDto.getId());
        assertEquals("Test Menu Item", menuItemDto.getTitle());
        assertEquals(15, menuItemDto.getServeTime());
        assertEquals(200, menuItemDto.getWeight());
        assertEquals(10, menuItemDto.getPrice());
        assertEquals("item.jpg", menuItemDto.getImageName());
        assertEquals("Ingredient 1 : 100", menuItemDto.getIngredients());
    }

    @Test
    public void testToMenuItem() {
        MenuItemDto menuItemDto = new MenuItemDto(2L,
                "Test Menu Item 2",
                15,
                250,
                15,
                "Ingredient 2 : 150",
                "item2.jpg");

        MenuItem menuItem = MenuItemConverter.toMenuItem(menuItemDto);

        assertEquals(2L, menuItem.getId());
        assertEquals("Test Menu Item 2", menuItem.getTitle());
        assertEquals(15, menuItem.getServeTime());
        assertEquals(250, menuItem.getWeight());
        assertEquals(15, menuItem.getPrice());
        assertEquals("item2.jpg", menuItem.getImageName());

        assertEquals(1, menuItem.getIngredientsList().size());
        MenuItemIngredient menuItemIngredient = menuItem.getIngredientsList().get(0);
        assertEquals("Ingredient 2", menuItemIngredient.getIngredient().getTitle());
        assertEquals(150, menuItemIngredient.getIngredient().getDosage());
    }
}