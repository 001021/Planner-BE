package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.controller;

import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto.Ingredient;
import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cooking/ingredient")
public class IngredientController {

    public final IngredientService ingredientService;

    @GetMapping
    public String listIngredient(Model model) {
        model.addAttribute("refrigeratorIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("냉장고"));
        model.addAttribute("freezerIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("냉동고"));
        model.addAttribute("roomIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("실온"));
        return "cooking/ingredient";
    }

    @GetMapping("/Refrigerator")
    public ResponseEntity<List<Ingredient>> getRefrigeratorIngredients() {
        List<Ingredient> ingredients = ingredientService.findByStorageLocationOrderByCreatedTimeDesc("냉장고");
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/Freezer")
    public ResponseEntity<List<Ingredient>> getFreezerIngredients() {
        List<Ingredient> ingredients = ingredientService.findByStorageLocationOrderByCreatedTimeDesc("냉동고");
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/RoomTemp")
    public ResponseEntity<List<Ingredient>> getRoomIngredients() {
        List<Ingredient> ingredients = ingredientService.findByStorageLocationOrderByCreatedTimeDesc("실온");
        return ResponseEntity.ok(ingredients);
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Ingredient newIngredient) {
        System.out.println("newIngredient: " + newIngredient);
        ingredientService.save(newIngredient);
        return "redirect:/cooking/ingredient";
    }

    @PostMapping("/save-in-modal")
    @ResponseBody
    public ResponseEntity<?> saveInModal(@RequestBody Map<String, Object> newIngredient) {

        try {
            Ingredient ingredient = new Ingredient();
            ingredient.setIngredientName((String) newIngredient.get("ingredientName"));
            ingredient.setQuantity(Integer.parseInt((String) newIngredient.get("quantity")));
            ingredient.setUnit((String) newIngredient.get("unit"));
            ingredient.setStorageLocation((String) newIngredient.get("storageLocation"));

            ingredientService.save(ingredient);
            return ResponseEntity.ok(ingredient);
        } catch (Exception e) {
            log.info("Error saving ingredient: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving ingredient");
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable("id") UUID id) {
        ingredientService.deleteById(id);
        return "redirect:/cooking/ingredient";
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public ResponseEntity<?> updateIngredient(@PathVariable("id") UUID id, @RequestBody Map<String, Object> updates) {
        try {
            Ingredient ingredient = ingredientService.findById(id);
            log.info("ingredient: " + ingredient);
            if (ingredient != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String ingredientName = (String) updates.get("ingredientName");
                int quantity = Integer.parseInt((String) updates.get("quantity"));
                String unit = (String) updates.get("unit");
                String expirationDateStr = (String) updates.get("expirationDate");
                Date expirationDate;
                if (expirationDateStr == null || expirationDateStr.isEmpty()) {
                    expirationDate = null;
                } else {
                    expirationDate = dateFormat.parse(expirationDateStr);
                }
                String status = (String) updates.get("status");
                String memo = (String) updates.get("memo");

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

    @PostMapping("/update/quantity/{id}")
    @ResponseBody
    public ResponseEntity<?> updateIngredientQuantity(@PathVariable("id") UUID id, @RequestBody Map<String, Object> updates) {
        try {
            Ingredient ingredient = ingredientService.findById(id);
            if (ingredient != null) {
                int quantity = Integer.parseInt((String) updates.get("quantity"));
                ingredient.setQuantity(quantity);
                ingredientService.save(ingredient);
                return ResponseEntity.ok(ingredient);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println("Error updating ingredient: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating ingredient");
        }
    }



}
