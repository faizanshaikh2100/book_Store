package com.example.book_app.ViewController;

import com.example.book_app.Model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegisterView {

@GetMapping("/login")
public String login(Model model){
    Author author = new Author();
    model.addAttribute("author",author);
    return "login";
}
@GetMapping("/register")
public String register(Model model){
        return "register";
    }
}
