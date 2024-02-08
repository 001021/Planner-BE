package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.controller;

import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto.Ingredient;
import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cooking/ingredient")
public class IngredientController {

    public final IngredientService ingredientService;

    @GetMapping
    public String listIngredient(Model model) {
        List<Ingredient> ingredientList = ingredientService.findAllByOrderByIngredientNameDesc();
        model.addAttribute("ingredientList", ingredientList);
        return "cooking/ingredient";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Ingredient newIngredient) {
        ingredientService.save(newIngredient);
        return "redirect:/cooking/ingredient";
    }

    @PostMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable UUID id) {
        ingredientService.deleteById(id);
        return "redirect:/cooking/ingredient";
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public String updateIngredient(@PathVariable UUID id, @RequestBody Ingredient ingredient) {
        log.info("ingredient: {}", ingredient);
        ingredientService.save(ingredient);
        return "redirect:/cooking/ingredient";
    }


}
