package ru.hynea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hynea.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
