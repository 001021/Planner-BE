package com.ktds.finalproject.plannerbe.domain.cleaning.checklist.controller;

import com.ktds.finalproject.plannerbe.domain.cleaning.checklist.dto.CleaningTodoItem;
import com.ktds.finalproject.plannerbe.domain.cleaning.checklist.service.CleaningTodoItemService;
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
@RequestMapping("/cleaning-todos")
public class CleaningTodoItemController {

    private final CleaningTodoItemService cleaningTodoItemService;

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todolist", cleaningTodoItemService.findAllByOrderByCreatedTimeDesc());
        return "cleaning-task/todolist";
    }

    @PostMapping
    public String save(@ModelAttribute("newTodo") CleaningTodoItem newTodo) {
        cleaningTodoItemService.save(newTodo);
        return "redirect:/cleaning-todos";
    }

    @PostMapping("/{id}/complete")
    public String complete(@ModelAttribute("newTodo") CleaningTodoItem cleaningTodoItem) {
        cleaningTodoItemService.save(cleaningTodoItem);
        return "redirect:/cleaning-todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable UUID id) {
        cleaningTodoItemService.deleteById(id);
        return "redirect:/cleaning-todos";
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateTodo(@PathVariable UUID id, @RequestBody Map<String, Object> updates) {
        try {
            CleaningTodoItem todoItem = cleaningTodoItemService.findById(id);
            if (todoItem != null) {
                String taskName = (String) updates.get("taskName");
                todoItem.setTaskName(taskName);
                cleaningTodoItemService.save(todoItem);
                return ResponseEntity.ok(todoItem);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating todo item");
        }
    }

    @PostMapping("/update/status/{id}")
    @ResponseBody
    public ResponseEntity<?> updateTodoStatus(@PathVariable UUID id) {
        try {
            CleaningTodoItem todoItem = cleaningTodoItemService.findById(id);
            if (todoItem != null) {
                todoItem.setCompleted(!todoItem.isCompleted());
                cleaningTodoItemService.save(todoItem);
                return ResponseEntity.ok(todoItem.isCompleted());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating todo item");
        }
    }




}
