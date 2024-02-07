package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.service;

import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto.Ingredient;
import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
