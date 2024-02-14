package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.service;

import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto.Ingredient;
import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IngredientService {

    public final IngredientRepository ingredientRepository;

    public List<Ingredient> findAllByOrderByItemNameDesc() {
        return ingredientRepository.findAllByOrderByIngredientNameDesc();
    }

    public void save(Ingredient newIngredient) {
        ingredientRepository.save(newIngredient);
    }

    public List<Ingredient> findAllByOrderByIngredientNameDesc() {
        return ingredientRepository.findAllByOrderByIngredientNameDesc();
    }

    public void deleteById(UUID id) {
        ingredientRepository.deleteById(id);
    }

    public Ingredient findById(UUID id) {
        return ingredientRepository.findById(id).orElse(null);
    }


    public List<Ingredient> findByStorageLocationOrderByCreatedTimeDesc(String location) {
        return ingredientRepository.findByStorageLocationOrderByCreatedTimeDesc(location);
    }

    public Object findAllByOrderByCreatedTimeDesc() {
        return ingredientRepository.findAllByOrderByCreatedTimeDesc();
    }
}
