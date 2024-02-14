package com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.repository;

import com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.dto.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID> {

    List<ShoppingList> findAllByOrderByItemNameDesc();
}
