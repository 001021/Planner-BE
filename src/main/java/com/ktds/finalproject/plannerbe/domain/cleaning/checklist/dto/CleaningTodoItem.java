package com.ktds.finalproject.plannerbe.domain.cleaning.checklist.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CleaningTodoItem {

    @Id
    @GeneratedValue
    @Column(name = "cleaningTodoItemId", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "taskName")
    private String taskName;

    @Column(name = "isCompleted")
    private boolean completed = false;
}
