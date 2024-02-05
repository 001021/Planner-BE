package com.ktds.finalproject.plannerbe.domain.cleaning.checklist.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CleaningTodoItem {

    @Id
    @GeneratedValue
    @Column(name = "cleaningTodoItemId", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "taskName", nullable = false)
    private String taskName;

    @Column(name = "isCompleted", nullable = false)
    private boolean completed = false;

    @Column(name = "createdTime", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdTime;
}
