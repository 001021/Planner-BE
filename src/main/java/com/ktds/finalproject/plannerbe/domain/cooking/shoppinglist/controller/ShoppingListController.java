package com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.controller;

import com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.dto.ShoppingList;
import com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cooking/shopping-list")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @GetMapping
    public String listShoppingList(Model model) {
        model.addAttribute("shoppinglist", shoppingListService.findAllByOrderByItemNameDesc());
        return "cooking/shopping-list";
    }

    @PostMapping
    public String save(@ModelAttribute("newShoppingList") ShoppingList newShoppingList) {
        shoppingListService.save(newShoppingList);
        return "redirect:/cooking/shopping-list";
    }

    @PostMapping("/delete/{id}")
    public String deleteShoppingList(@PathVariable UUID id) {
        shoppingListService.deleteById(id);
        return "redirect:/cooking/shopping-list";
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateShoppingList(@PathVariable UUID id, @RequestBody Map<String, Object> updates) {
        try {
            ShoppingList shoppingList = shoppingListService.findById(id);
            if (shoppingList != null) {
                String itemName = (String) updates.get("itemName");
                int quantity = (int) updates.get("quantity");
                shoppingList.setItemName(itemName);
                shoppingList.setQuantity(quantity);
                shoppingListService.save(shoppingList);
                return ResponseEntity.ok(shoppingList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating todo item");
        }
    }

    @PostMapping("/update/status/{id}")
    @ResponseBody
    public ResponseEntity<?> updateShoppingListPurchase(@PathVariable UUID id, @RequestBody Map<String, Object> updates) {
        try {
            ShoppingList shoppingList = shoppingListService.findById(id);
            if (shoppingList != null) {
                boolean isPurchased = (boolean) updates.get("isPurchased");
                shoppingList.setPurchased(isPurchased);
                shoppingListService.save(shoppingList);
                return ResponseEntity.ok(shoppingList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating todo item");
        }
    }

    @PostMapping("/update/quantity/{id}")
    @ResponseBody
    public ResponseEntity<?> updateShoppingListQuantity(@PathVariable UUID id, @RequestBody Map<String, Object> updates) {
        try {
            ShoppingList shoppingList = shoppingListService.findById(id);
            if (shoppingList != null) {
                int quantity = (int) updates.get("quantity");
                shoppingList.setQuantity(quantity);
                shoppingListService.save(shoppingList);
                return ResponseEntity.ok(shoppingList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating todo item");
        }
    }

}
