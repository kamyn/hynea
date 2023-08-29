package ru.hynea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menu_item_ingredient", schema="hynea")
public class MenuItemIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
}
