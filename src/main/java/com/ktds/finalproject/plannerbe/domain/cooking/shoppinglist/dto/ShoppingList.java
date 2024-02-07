package com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class ShoppingList {

    @Id
    @GeneratedValue
    @Column(name = "shoppingListId", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "itemName", nullable = false)
    private String itemName;

    @Column(name = "quantity")
    private int quantity = 1;

    @Column(name = "unit")
    private String unit = "개";

    @Column(name = "isPurchased", nullable = false)
    private boolean isPurchased = false;

}
