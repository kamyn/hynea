package ru.hynea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.model.Breakfast;
import ru.hynea.repository.BreakfastRepository;
import java.util.List;

@Service
public class BreakfastService {
    @Autowired
    private final BreakfastRepository breakfastRepository;
    public BreakfastService(BreakfastRepository breakfastRepository) {
        this.breakfastRepository = breakfastRepository;
    }

    public List<Breakfast> findAll() {
        return breakfastRepository.findAll();
    }
}
