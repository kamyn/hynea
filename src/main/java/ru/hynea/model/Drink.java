package ru.hynea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="drink", schema="hynea")
public class Drink {
    @Id
    private Long id;

    @OneToOne
    private MenuItem menu_item;
}