package com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.service;


import com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.dto.ShoppingList;
import com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.repository.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public List<ShoppingList> findAllByOrderByItemNameDesc() {
        return shoppingListRepository.findAllByOrderByItemNameDesc();
    }

    public void save(ShoppingList newShoppingList) {
        shoppingListRepository.save(newShoppingList);
    }

    public void deleteById(UUID id) {
        shoppingListRepository.deleteById(id);
    }

    public ShoppingList findById(UUID id) {
        return shoppingListRepository.findById(id).orElse(null);
    }
}
