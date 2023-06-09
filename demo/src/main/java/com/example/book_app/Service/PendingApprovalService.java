package com.example.book_app.Service;


import com.example.book_app.Model.Author;
import com.example.book_app.Model.Book;
import com.example.book_app.Model.PendingApproval;
import com.example.book_app.Repository.AuthorRepo;
import com.example.book_app.Repository.PendingApporvalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class PendingApprovalService {

    @Autowired
    private PendingApporvalRepo pendingApporvalRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private AuthorService authorService;

    public String addBook(Book book) {
        PendingApproval pendingApproval = new PendingApproval();
        pendingApproval.setBookId(book.getBookId());
        pendingApproval.setBookName(book.getBookName() );
        pendingApproval.setAuthorId(book.getAuthorId());
        pendingApproval.setAuthorName(book.getAuthorName());
        pendingApproval.setPrice(book.getPrice());
        pendingApproval.setGenre(book.getGenre());
        pendingApporvalRepo.save(pendingApproval);
        //add book to author

        return "Approval Request Sent";
    }

    public List<PendingApproval> getAllPendingApprovals() {
        return pendingApporvalRepo.findAll();
    }

    public PendingApproval getPendingApprovalById(int i) {
        return pendingApporvalRepo.findById(i).get();
    }

    public void deletePendingApproval(int i) {
        pendingApporvalRepo.deleteById(i);
    }
}
