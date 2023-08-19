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
@Table(name="salad", schema="hynea")
public class Salad {
    @Id
    private Long id;
    @OneToOne
    private MenuItem menuItem;
}
