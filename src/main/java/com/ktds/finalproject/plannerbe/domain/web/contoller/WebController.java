package com.ktds.finalproject.plannerbe.domain.web.contoller;

import com.ktds.finalproject.plannerbe.domain.cleaning.checklist.service.CleaningTodoItemService;
import com.ktds.finalproject.plannerbe.domain.cooking.ingredient.service.IngredientService;
import com.ktds.finalproject.plannerbe.domain.cooking.shoppinglist.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final CleaningTodoItemService cleaningTodoItemService;
    private final ShoppingListService shoppingListService;
    private final IngredientService ingredientService;

    @GetMapping("/")
    public String showIndex(Model model) {

        model.addAttribute("todolist", cleaningTodoItemService.findAllByOrderByCreatedTimeDesc());
        model.addAttribute("shoppinglist", shoppingListService.findAllByOrderByItemNameDesc());
        model.addAttribute("refrigeratorIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("냉장고"));
        model.addAttribute("freezerIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("냉동고"));
        model.addAttribute("roomIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("실온"));

        return "index";
    }

    @GetMapping("/index")
    public String showIndex2(Model model) {
        model.addAttribute("todolist", cleaningTodoItemService.findAllByOrderByCreatedTimeDesc());
        model.addAttribute("shoppinglist", shoppingListService.findAllByOrderByItemNameDesc());
        model.addAttribute("refrigeratorIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("냉장고"));
        model.addAttribute("freezerIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("냉동고"));
        model.addAttribute("roomIngredients", ingredientService.findByStorageLocationOrderByCreatedTimeDesc("실온"));
        return "index";
    }

    @GetMapping("/forms")
    public String showForms() {
        return "forms";
    }

    @GetMapping("/cards")
    public String showCards() {
        return "cards";
    }

    @GetMapping("/buttons")
    public String showButtons() {
        return "buttons";
    }

    @GetMapping("/charts")
    public String showCharts() {
        return "charts";
    }

    @GetMapping("/tables")
    public String showTables() {
        return "tables";
    }

    @GetMapping("/modals")
    public String showModals() {
        return "modals";
    }

    @GetMapping("/404")
    public String show404() {
        return "404";
    }

    @GetMapping("/blank")
    public String showBlank() {
        return "blank";
    }

    @GetMapping("/forgot-password")
    public String showForgotPassword() {
        return "forgot-password";
    }

    @GetMapping("/cleaning-task/todolist")
    public String showCleaningTodoList() {
        return "/cleaning-task/todolist";
    }

}
