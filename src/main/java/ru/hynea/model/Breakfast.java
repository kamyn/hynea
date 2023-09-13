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
@Setter
@Getter
@Table(name="breakfast", schema="hynea")
public class Breakfast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private Integer price;

    @OneToMany(mappedBy="breakfast", cascade = CascadeType.ALL)
    private List<MenuItemBreakfast> menuItemBreakfastList;

    @Column(name="image_name")
    private String imageName;
}

