package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue
    @Column(name = "ingredientId", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "ingredientName", nullable = false)
    private String ingredientName;

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "unit")
    private String unit; // 추후 Enum으로 변경

    @Column(name = "category")
    private String category; // 추후 Enum으로 변경

    @Column(name = "expirationDate")
    private Timestamp expirationDate;

    @Column(name = "purchaseDate")
    private Timestamp purchaseDate;

    @Column(name = "storageLocation")
    private String storageLocation;

    @Column(name = "status")
    private String status; // 추후 Enum으로 변경

    @Column(name = "memo")
    private String memo;

}
