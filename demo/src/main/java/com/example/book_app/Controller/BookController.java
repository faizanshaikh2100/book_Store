package com.example.book_app.Controller;

import com.example.book_app.Model.Book;
import com.example.book_app.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/getApprovedBooks")
    public String getApprovedBooks(Model model){
        model.addAttribute("approvedBooks",bookRepo.findAll());
        return "books";
    }

}
