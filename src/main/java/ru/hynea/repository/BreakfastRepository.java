package ru.hynea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hynea.model.Breakfast;
import ru.hynea.model.MenuItem;

public interface BreakfastRepository extends JpaRepository<Breakfast, Long> {

}