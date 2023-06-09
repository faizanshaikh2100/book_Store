package com.example.book_app.Controller;

import com.example.book_app.Model.Author;
import com.example.book_app.Model.Book;
import com.example.book_app.Model.PendingApproval;
import com.example.book_app.Repository.PendingApporvalRepo;
import com.example.book_app.Service.AuthorService;
import com.example.book_app.Service.BookService;
import com.example.book_app.Service.PendingApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private PendingApprovalService pendingApprovalService;


    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody Author author){

        return authorService.addAuthor(author);
    }

    @GetMapping("/getAuthor/{id}")
    public Author getAuthor(@PathVariable("id") int id){
       return authorService.getAuthor(id);
    }

    @PostMapping("/publishBook")
    public String publishBook(@RequestBody Book book) {

       return pendingApprovalService.addBook(book);
    }


    @PutMapping("/updateAuthor")
    public String updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }


}

