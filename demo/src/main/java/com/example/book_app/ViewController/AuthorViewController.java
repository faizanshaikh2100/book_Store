package com.example.book_app.ViewController;

import com.example.book_app.Model.Author;
import com.example.book_app.Model.AuthorBookDto;
import com.example.book_app.Model.Book;
import com.example.book_app.Model.PendingApproval;
import com.example.book_app.Repository.AuthorRepo;
import com.example.book_app.Repository.PendingApporvalRepo;
import com.example.book_app.Service.PendingApprovalService;
import com.example.book_app.Util.ApprovalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( "/author")
public class AuthorViewController {
    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private PendingApporvalRepo  pendingApporvalRepo;

    @GetMapping("/getAllAuthors")


    public String listAuthors(Model model){


        model.addAttribute("authors",authorRepo.findAll());

        return "authors";
    }

    @PostMapping (value = "/addAuthor2")
    public String addAuthor(@ModelAttribute("author") Author author,Model model){

        authorRepo.save(author);
        AuthorBookDto authorBookDto = new AuthorBookDto();
        Author a = authorRepo.findByEmail(author.getEmail());
        authorBookDto.setAuthor(a);
        model.addAttribute("bookAndAuthor",authorBookDto);
        return "login2";
    }

    @PostMapping("/publishBook2")
    public String publishBook(@ModelAttribute("bookAndAuthor") AuthorBookDto authorBookDto, Model model){
         Book book =  authorBookDto.getBook();
         String authorEmail = authorBookDto.getAuthor().getEmail();
        Author a = authorRepo.findByEmail(authorEmail);
        book.setAuthorName(a.getAuthorName());
        book.setAuthorId(a.getAuthorId());
        ApprovalUtil approvalUtil = new ApprovalUtil();
        PendingApproval p =approvalUtil.convertBookToPendingBook(book);
        pendingApporvalRepo.save(p);
        authorBookDto = new AuthorBookDto();
        authorBookDto.setAuthor(a);
        model.addAttribute("bookAndAuthor",authorBookDto);
           return "authorProfile";
    }
    @GetMapping("/login")
    public String login(Model model){
        Author author = new Author();
        model.addAttribute("author",author);
        return "login";
    }

    @PostMapping("/getAuthorByEmail")
    public String getAuthorByEmail(@ModelAttribute("bookAndAuthor")AuthorBookDto authorBookDto,Model model){
        String email = authorBookDto.getAuthor().getEmail().trim();
        Author author = authorRepo.findByEmail(email);
        authorBookDto.setAuthor(author);
        model.addAttribute("bookAndAuthor",authorBookDto);
        if(author.getPassword()!=author.getPassword()) {
            return "wrongPassword";
        }else {
            return "authorProfile";
        }
    }
    @GetMapping("/login2")
    public String login2(Model model){
        Author author = new Author();
        model.addAttribute("author",author);
        return "login2";
    }

}