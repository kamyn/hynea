package ru.hynea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.converter.BreakfastItemConverter;
import ru.hynea.dto.BreakfastItemDto;
import ru.hynea.model.Breakfast;
import ru.hynea.repository.BreakfastRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BreakfastService {

    private final BreakfastRepository breakfastRepository;
    public BreakfastItemDto findById(Long id) {
        return BreakfastItemConverter.toDto(breakfastRepository.findById(id).orElse(new Breakfast()));
    }
    public List<BreakfastItemDto> findAll() {
        return breakfastRepository.findAll()
                .stream()
                .map(BreakfastItemConverter::toDto)
                .collect(Collectors.toList());
    }
}
