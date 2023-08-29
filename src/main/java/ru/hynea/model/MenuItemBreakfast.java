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

    @OneToOne
    @JoinColumn(name = "menu_item_id", insertable = false, updatable = false)
    private MenuItem menu_item;

    @ManyToOne
    @JoinColumn(name = "breakfast_id", insertable = false, updatable = false)
    private Breakfast breakfast;
}