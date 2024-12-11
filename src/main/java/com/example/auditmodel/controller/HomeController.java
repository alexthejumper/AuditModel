package com.example.auditmodel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {

    // Add this logger in the `HomeController` or authentication-related parts
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/public")
    @ResponseBody
    public String publicPage() {
        return "This is a public page.";
    }

    @GetMapping("/private")
    public String privatePage(Model model, Authentication authentication) {
        logger.info("User {} accessed the private page.", authentication.getName());

        model.addAttribute("authenticationName", authentication.getName());
        //return "Hello, " + authentication.getName() + "! This is a private page.";

        return "loginSuccess";
    }

    @GetMapping("/authenticated")
    @ResponseBody
    public String authenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return "Authenticated user: " + auth.getName();
        } else {
            return "No user authenticated.";
        }
    }
}
