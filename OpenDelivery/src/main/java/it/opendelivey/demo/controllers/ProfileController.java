package it.opendelivey.demo.controllers;

import it.opendelivey.demo.handlers.ProfileHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(
            @RequestParam("id") int id,
            @RequestParam("op") String operation,
            @RequestParam("password") String password
    ){
        return "profile";
    }
}
