package ru.hynea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hynea.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}