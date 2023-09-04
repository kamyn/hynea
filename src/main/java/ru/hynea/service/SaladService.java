package ru.hynea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.converter.MenuItemConverter;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.Salad;
import ru.hynea.repository.SaladRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaladService {
    private final SaladRepository saladRepository;
    @Autowired
    public SaladService(SaladRepository saladRepository) {
        this.saladRepository = saladRepository;
    }

    public List<MenuItemDto> findAll() {
        return saladRepository.findAll()
                .stream()
                .map(x -> MenuItemConverter.toDto(x.getMenu_item()))
                .collect(Collectors.toList());
    }
}
