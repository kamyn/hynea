package ru.hynea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hynea.model.User;
import ru.hynea.repository.UserRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) { return userRepository.findById(id).orElse(null);}

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
