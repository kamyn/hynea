package ru.hynea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menu_item", schema="hynea")
public class MenuItem {
    @Id
    private Long id;

    private String title;

    private Integer serveTime;

    private Integer weight;

    private Integer price;

    @OneToMany(mappedBy="menuItems")
    private List<MenuItemIngredient> ingredientsList;
}