package com.ktds.finalproject.plannerbe.domain.web.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/index")
    public String showIndex2() {
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

}
