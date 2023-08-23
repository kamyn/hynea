package ru.hynea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hynea.model.Salad;
import ru.hynea.repository.SaladRepository;
import java.util.List;

@Service
public class SaladService {
    @Autowired
    private final SaladRepository saladRepository;
    public SaladService(SaladRepository saladRepository) {
        this.saladRepository = saladRepository;
    }

    public List<Salad> findAll() {
        return saladRepository.findAll();
    }
}
