package ru.hynea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ingredient", schema="hynea")
public class Ingredient {
    @Id
    private Long id;
    private String title;
    private Integer dosage;

    @OneToOne(mappedBy="ingredient")
    private MenuItemIngredient menuItemIngredient;
}