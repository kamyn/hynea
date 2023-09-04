package ru.hynea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.converter.MenuItemConverter;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.Drink;
import ru.hynea.repository.DrinkRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;
    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<MenuItemDto> findAll() {
        return drinkRepository.findAll()
                .stream()
                .map(x -> MenuItemConverter.toDto(x.getMenu_item()))
                .collect(Collectors.toList());
    }
}
