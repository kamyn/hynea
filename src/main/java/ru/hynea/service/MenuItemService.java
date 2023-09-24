package ru.hynea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hynea.converter.MenuItemConverter;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.MenuItem;
import ru.hynea.repository.MenuItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemConverter menuItemConverter;

    public MenuItemDto findById(Long id) {
        return menuItemConverter.toDto(menuItemRepository.findById(id).orElse(null));
    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }

    public List<MenuItemDto> findAll() {
        return menuItemRepository.findAll()
                .stream()
                .map(menuItemConverter::toDto)
                .collect(Collectors.toList());
    }

    public void saveMenuItem(MenuItemDto menuItemDto) {
        if (menuItemDto.getId() != null) {
            Optional<MenuItem> optRec = menuItemRepository.findById(menuItemDto.getId());
            if (optRec.isPresent()) {
                MenuItem rec = optRec.get();
                menuItemDto.setImageName(rec.getImageName());
                menuItemRepository.deleteById(menuItemDto.getId());
            }
        }
        menuItemRepository.save(menuItemConverter.toMenuItem(menuItemDto));
    }
}
