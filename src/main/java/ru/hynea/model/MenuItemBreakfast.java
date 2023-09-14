package ru.hynea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="menu_item_breakfast", schema="hynea")
public class MenuItemBreakfast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "breakfast_id")
    private Breakfast breakfast;
}