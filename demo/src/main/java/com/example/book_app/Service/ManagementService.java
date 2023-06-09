package com.example.book_app.Service;

import com.example.book_app.Model.Author;
import com.example.book_app.Model.Book;
import com.example.book_app.Model.PendingApproval;
import com.example.book_app.Repository.AuthorRepo;
import com.example.book_app.Repository.BookRepo;
import com.example.book_app.Util.ApprovalUtil;
import com.example.book_app.functionalities.IntegerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {


    @Autowired
    private PendingApprovalService pendingApprovalService;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorRepo authorRepo;
    public String approveBook(int id) {
        PendingApproval p = pendingApprovalService.getPendingApprovalById(id);
        Book book = new ApprovalUtil().convertPendingBookToBook(p);
//        bookRepo.save(book);
        int id1 = book.getAuthorId();
        Author oldAuthor = authorRepo.findById(id1).get();
        oldAuthor.getBookList().add(book);
        authorService.updateAuthor(oldAuthor);
        pendingApprovalService.deletePendingApproval(id);
        return "Approved";
    }
    public String rejectBook(int id) {
        pendingApprovalService.deletePendingApproval(id);
        return "Rejected";
    }
    public Book getBook(int id) {
        return bookRepo.findById(id).get();
    }
}
