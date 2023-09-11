package ru.hynea.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class BreakfastItemDto {
    private Long id;

    private String title;

    private Integer price;

    private String imageName;

    private HashMap<Long, String> menuItemsList;

    public BreakfastItemDto() {

    }

    public  BreakfastItemDto(Long id, String title, Integer price, String imageName, HashMap<Long, String> menuItemsList) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.imageName = imageName;
        this.menuItemsList = menuItemsList;
    }
}
