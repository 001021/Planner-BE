package com.ktds.finalproject.plannerbe.domain.cleaning.checklist.service;

import com.ktds.finalproject.plannerbe.domain.cleaning.checklist.dto.CleaningTodoItem;
import com.ktds.finalproject.plannerbe.domain.cleaning.checklist.repository.CleaningTodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CleaningTodoItemService {

    private final CleaningTodoItemRepository cleaningTodoItemRepository;

    public List<CleaningTodoItem> findAll() {
        return cleaningTodoItemRepository.findAll();
    }

    public CleaningTodoItem findById(UUID id) {
        return cleaningTodoItemRepository.findById(id).orElse(null);
    }

    public CleaningTodoItem save(CleaningTodoItem cleaningTodoItem) {
        return cleaningTodoItemRepository.save(cleaningTodoItem);
    }


    public void deleteById(UUID id) {
        cleaningTodoItemRepository.deleteById(id);
    }

    public void update(CleaningTodoItem cleaningTodoItem) {
        cleaningTodoItemRepository.save(cleaningTodoItem);
    }
}
