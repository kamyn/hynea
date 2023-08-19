package ru.hynea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menu_item_breakfast", schema="hynea")
public class MenuItemBreakfast {
    @Id
    private Long id;
    @OneToOne
    private MenuItem menuItem;
    @OneToOne
    private Breakfast breakfast;
}