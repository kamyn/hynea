package ru.hynea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.converter.MenuItemConverter;
import ru.hynea.dto.MenuItemDto;
import ru.hynea.model.MenuItem;
import ru.hynea.repository.MenuItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItemDto findById(Long id) {
        return MenuItemConverter.toDto(menuItemRepository.findById(id).orElse(new MenuItem()));
    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }

    public List<MenuItemDto> findAll() {
        return menuItemRepository.findAll()
                .stream()
                .map(MenuItemConverter::toDto)
                .collect(Collectors.toList());
    }

    public void saveMenuItem(MenuItemDto menuItemDto) {
        if (menuItemDto.getId() != null) {
            var rec = menuItemRepository.findById(menuItemDto.getId()).orElse(null);
            if (rec != null) {
                menuItemDto.setImageName(rec.getImage_name());
                menuItemRepository.deleteById(menuItemDto.getId());
            }
        }
        menuItemRepository.save(MenuItemConverter.toMenuItem(menuItemDto));
    }
}
