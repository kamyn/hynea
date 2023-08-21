package ru.hynea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hynea.model.Salad;

public interface SaladRepository extends JpaRepository<Salad, Long> {
}
