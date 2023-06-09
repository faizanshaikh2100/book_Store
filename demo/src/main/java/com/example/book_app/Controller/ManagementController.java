package com.example.book_app.Controller;

import com.example.book_app.Model.Author;
import com.example.book_app.Model.Book;
import com.example.book_app.Model.PendingApproval;
import com.example.book_app.Repository.AuthorRepo;
import com.example.book_app.Repository.BookRepo;
import com.example.book_app.Repository.PendingApporvalRepo;
import com.example.book_app.Service.AuthorService;
import com.example.book_app.Service.BookService;
import com.example.book_app.Service.ManagementService;
import com.example.book_app.Service.PendingApprovalService;
import com.example.book_app.Util.ApprovalUtil;
import com.example.book_app.functionalities.IntegerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping( "/management")
public class ManagementController {

    @Autowired
    private PendingApprovalService pendingApprovalService;

    @Autowired
    private ManagementService managementService;

    @GetMapping("/pendingBookApprovals")
    public List<PendingApproval> pendingBookApprovals(){
        return pendingApprovalService.getAllPendingApprovals();
    }

    //add conditions to check if the book is already in the database
    @DeleteMapping("/approveBook/{id}")
    public String approveBook(@PathVariable("id") int id){
        return managementService.approveBook(id);
    }
    @DeleteMapping("/rejectBook/{id}")
    public String rejectBook(@PathVariable("id") int id){
        return managementService.rejectBook(id);
    }


    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable("id") int id){
        return managementService.getBook(id);
    }
}
