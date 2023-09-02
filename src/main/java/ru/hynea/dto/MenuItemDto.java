package ru.hynea.dto;

import jakarta.persistence.*;
import lombok.Data;
import ru.hynea.model.MenuItemIngredient;

import java.util.List;

@Data
public class MenuItemDto {
    private Long id;

    private String title;

    private Integer serveTime;

    private Integer weight;

    private Integer price;

    private String ingredients;

    private String imageName;

    public MenuItemDto() {

    }

    public MenuItemDto(Long id, String title, Integer serveTime, Integer weight,
                       Integer price, String ingredients, String imageName) {
        this.id = id;
        this.title = title;
        this.serveTime = serveTime;
        this.weight = weight;
        this.price = price;
        this.ingredients = ingredients;
        this.imageName = imageName;
    }
}
