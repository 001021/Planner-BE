package com.ktds.finalproject.plannerbe.domain.cleaning.checklist.repository;

import com.ktds.finalproject.plannerbe.domain.cleaning.checklist.dto.CleaningTodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CleaningTodoItemRepository extends JpaRepository<CleaningTodoItem, UUID> {

    List<CleaningTodoItem> findAllByOrderByCreatedTimeDesc();
}
