package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @Column(name = "purchaseDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    @Column(name = "storageLocation")
    private String storageLocation;

    @Column(name = "status")
    private String status; // 추후 Enum으로 변경

    @Column(name = "memo")
    private String memo;

}
