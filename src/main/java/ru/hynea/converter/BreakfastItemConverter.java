package ru.hynea.converter;

import org.springframework.stereotype.Component;
import ru.hynea.dto.BreakfastItemDto;
import ru.hynea.model.Breakfast;

import java.util.HashMap;

@Component
public class BreakfastItemConverter {
    public static BreakfastItemDto toDto(Breakfast breakfast) {
        HashMap<Long, String> breakfastMenuItems = new HashMap<>();
        for (var menuItem : breakfast.getMenuItemBreakfastList()) {
            breakfastMenuItems.put(menuItem.getMenuItem().getId(),
                                   menuItem.getMenuItem().getTitle());
        }

        return new BreakfastItemDto(breakfast.getId(),
                                    breakfast.getTitle(),
                                    breakfast.getPrice(),
                                    breakfast.getImageName(),
                                    breakfastMenuItems);
    }

    // TODO MenuItemBreakfastList relation
    public static Breakfast toBreakfast(BreakfastItemDto breakfastItemDto) {
        Breakfast breakfast = new Breakfast();

        breakfast.setId(breakfastItemDto.getId());
        breakfast.setTitle(breakfastItemDto.getTitle());
        breakfast.setPrice(breakfastItemDto.getPrice());
        breakfast.setImageName(breakfastItemDto.getImageName());

//        for (var breakfastMenu : breakfastItemDto.getMenuItemsList()) {
//
//        }

        return breakfast;
    }
}
