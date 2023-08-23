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
@Table(name="breakfast", schema="hynea")
public class Breakfast {
    @Id
    private Long id;

    private String title;

    private Integer price;

    @OneToMany(mappedBy="breakfast")
    private List<MenuItemBreakfast> menuItemBreakfastList;
}

