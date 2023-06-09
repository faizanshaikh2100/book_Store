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

@Controller
@RequestMapping( "/management")
public class ManagementController2 {

    @Autowired
    private PendingApprovalService pendingApprovalService;

    @Autowired
    private ManagementService managementService;

    @GetMapping("/approveBook/{bookId}")
    public String approveBook(@PathVariable("bookId") int id){
         managementService.approveBook(id);
        return "redirect:/management/pendingBookApprovals2";
    }
    @GetMapping("/rejectBook/{bookId}")
    public String rejectBook(@PathVariable("bookId") int id){
         managementService.rejectBook(id);
         return "redirect:/management/pendingBookApprovals2";
    }
}
