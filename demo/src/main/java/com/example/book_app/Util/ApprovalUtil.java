package com.example.book_app.Util;

import com.example.book_app.Model.PendingApproval;
import com.example.book_app.Model.Book;
public class ApprovalUtil {
     public Book convertPendingBookToBook(PendingApproval p) {

        Book book = new Book();
        book.setBookId(p.getBookId());
        book.setBookName(p.getBookName());
        book.setAuthorId(p.getAuthorId());
        book.setAuthorName(p.getAuthorName());
        book.setGenre(p.getGenre());
        book.setPrice(p.getPrice());
        return book;
    }
    public PendingApproval convertBookToPendingBook(Book book) {

         PendingApproval p = new PendingApproval();
        p.setBookId(book.getBookId());
        p.setBookName(book.getBookName());
        p.setAuthorId(book.getAuthorId());
        p.setAuthorName(book.getAuthorName());
        p.setGenre(book.getGenre());
        p.setPrice(book.getPrice());
        return p;
    }

}
