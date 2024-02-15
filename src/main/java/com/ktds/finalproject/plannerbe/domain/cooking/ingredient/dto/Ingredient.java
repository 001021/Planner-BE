package com.ktds.finalproject.plannerbe.domain.cooking.ingredient.dto;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Ingredient {

    @Id
    @GeneratedValue
    @Column(name = "ingredientId", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "ingredientName", nullable = false)
    private String ingredientName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit")
    private String unit; // 추후 Enum으로 변경

    @Column(name = "category")
    private String category; // 추후 Enum으로 변경

    @Column(name = "expirationDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @Column(name = "storageLocation", nullable = false)
    private String storageLocation;

    @Column(name = "status")
    private String status; // 추후 Enum으로 변경

    @Column(name = "memo")
    private String memo;

    @CreatedDate
    private LocalDateTime createdTime;

}
