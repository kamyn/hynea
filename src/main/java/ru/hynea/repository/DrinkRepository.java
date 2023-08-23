package ru.hynea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hynea.model.Drink;
import ru.hynea.model.MenuItem;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

}