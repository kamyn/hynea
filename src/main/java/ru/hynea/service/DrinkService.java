package ru.hynea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hynea.converter.MenuItemConverter;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.repository.DrinkRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public List<MenuItemDto> findAll() {
        return drinkRepository.findAll()
                .stream()
                .map(x -> MenuItemConverter.toDto(x.getMenuItem()))
                .collect(Collectors.toList());
    }
}
