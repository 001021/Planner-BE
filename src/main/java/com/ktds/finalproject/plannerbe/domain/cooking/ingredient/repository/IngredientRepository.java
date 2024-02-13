package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.repository;

import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    List<Ingredient> findAllByOrderByIngredientNameDesc();

    List<Ingredient> findByStorageLocation(String location);

    List<Ingredient> findAllByOrderByCreatedTime();
}
