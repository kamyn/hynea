package ru.hynea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hynea.converter.MenuItemConverter;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.repository.SaladRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaladService {

    private final SaladRepository saladRepository;

    public List<MenuItemDto> findAll() {
        return saladRepository.findAll()
                .stream()
                .map(x -> MenuItemConverter.toDto(x.getMenuItem()))
                .collect(Collectors.toList());
    }
}
