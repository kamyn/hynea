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
@Table(name="menu_item_breakfast", schema="hynea")
public class MenuItemBreakfast {
    @Id
    private Long id;
    @OneToMany
    private List<MenuItem> menu_item;
    @OneToOne
    private Breakfast breakfast;
}