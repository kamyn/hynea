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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer serve_time;

    private Integer weight;

    private Integer price;

    @OneToMany(mappedBy="menuItem")
    private List<MenuItemIngredient> ingredientsList;
}