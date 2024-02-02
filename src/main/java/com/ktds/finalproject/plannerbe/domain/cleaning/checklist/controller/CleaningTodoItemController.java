package com.ktds.finalproject.plannerbe.domain.cleaning.checklist.controller;

import com.ktds.finalproject.plannerbe.domain.cleaning.checklist.dto.CleaningTodoItem;
import com.ktds.finalproject.plannerbe.domain.cleaning.checklist.service.CleaningTodoItemService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cleaning-todos")
public class CleaningTodoItemController {

    private final CleaningTodoItemService cleaningTodoItemService;

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todolist", cleaningTodoItemService.findAll());
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
    public String update(@PathVariable UUID id, @ModelAttribute("todo") CleaningTodoItem updatedTodo) {
        CleaningTodoItem existingTodo = cleaningTodoItemService.findById(id);

        existingTodo.setTaskName(updatedTodo.getTaskName());
        existingTodo.setCompleted(updatedTodo.isCompleted());

        cleaningTodoItemService.save(existingTodo);

        return "redirect:/cleaning-todos";
    }



}
