package ru.hynea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.model.Drink;
import ru.hynea.repository.DrinkRepository;
import java.util.List;

@Service
public class DrinkService {
    @Autowired
    private final DrinkRepository drinkRepository;
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }
}
