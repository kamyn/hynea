package ru.hynea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="menu_item", schema="hynea")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="serve_time")
    private Integer serveTime;

    @Column(name="weight")
    private Integer weight;

    @Column(name="price")
    private Integer price;

    @OneToMany(mappedBy="menuItem", cascade = CascadeType.ALL)
    private List<MenuItemIngredient> ingredientsList;

    @Column(name="image_name")
    private String imageName;
}