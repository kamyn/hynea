package ru.hynea.converter;

import org.springframework.stereotype.Component;
import ru.hynea.dto.BreakfastItemDto;
import ru.hynea.model.Breakfast;
import ru.hynea.model.MenuItemBreakfast;

import java.util.HashMap;
import java.util.stream.Collectors;

@Component
public class BreakfastItemConverter {
    public static BreakfastItemDto toDto(Breakfast breakfast) {
        HashMap<Long, String> breakfastMenuItems = new HashMap<>();
        for (var menuItem : breakfast.getMenuItemBreakfastList()) {
            breakfastMenuItems.put(menuItem.getMenu_item().getId(),
                                   menuItem.getMenu_item().getTitle());
        }

        return new BreakfastItemDto(breakfast.getId(),
                                    breakfast.getTitle(),
                                    breakfast.getPrice(),
                                    breakfast.getImage_name(),
                                    breakfastMenuItems);
    }

    // TODO MenuItemBreakfastList relation
    public static Breakfast toBreakfast(BreakfastItemDto breakfastItemDto) {
        Breakfast breakfast = new Breakfast();

        breakfast.setId(breakfastItemDto.getId());
        breakfast.setTitle(breakfastItemDto.getTitle());
        breakfast.setPrice(breakfastItemDto.getPrice());
        breakfast.setImage_name(breakfastItemDto.getImageName());

//        for (var breakfastMenu : breakfastItemDto.getMenuItemsList()) {
//
//        }

        return breakfast;
    }
}
