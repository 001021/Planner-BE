package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.controller;

import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto.Ingredient;
import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.service.IngredientService;
import com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.dto.ShoppingList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public ResponseEntity<?> updateIngredient(@PathVariable UUID id, @RequestBody Map<String, Object> updates) {
        try {
            Ingredient ingredient = ingredientService.findById(id);
            log.info("ingredient: " + ingredient);
            if (ingredient != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                log.info("updates: " + updates);
                String ingredientName = (String) updates.get("ingredientName");
                log.info("ingredientName: " + ingredientName);
                Integer quantity = Integer.parseInt((String) updates.get("quantity"));
                log.info("quantity: " + quantity);
                String unit = (String) updates.get("unit");
                log.info("unit: " + unit);
                String expirationDateStr = (String) updates.get("expirationDate");
                Date expirationDate = dateFormat.parse(expirationDateStr);
                log.info("expirationDate: " + expirationDate);
                String status = (String) updates.get("status");
                log.info("status: " + status);
                String memo = (String) updates.get("memo");
                log.info("memo: " + memo);

                ingredient.setIngredientName(ingredientName);
                ingredient.setQuantity(quantity);
                ingredient.setUnit(unit);
                ingredient.setExpirationDate(expirationDate);
                ingredient.setStatus(status);
                ingredient.setMemo(memo);

                ingredientService.save(ingredient);
                return ResponseEntity.ok(ingredient);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.info("Error updating ingredient: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating ingredient");
        }
    }


}
