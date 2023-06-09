package com.example.book_app.Controller;

import com.example.book_app.Service.PendingApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/management")
public class ViewController{
    @Autowired
    private PendingApprovalService pendingApprovalService;
    @GetMapping("/pendingBookApprovals2")

    public String listPendingApprovals(Model model){

        model.addAttribute("pendingApprovals",pendingApprovalService.getAllPendingApprovals());

        return "pendingBookApprovals";
    }
}
