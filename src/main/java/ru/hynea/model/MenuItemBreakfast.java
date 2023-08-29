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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menu_item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "breakfast_id")
    private Breakfast breakfast;
}