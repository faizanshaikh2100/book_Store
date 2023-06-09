package com.example.book_app.Service;

import com.example.book_app.Model.Author;
import com.example.book_app.Model.Book;
import com.example.book_app.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    AuthorRepo authorRepo;
    public String addBook(Book book) {
        int authorId = book.getAuthorId();
        Author author = authorRepo.findById(authorId).get();
        author.getBookList().add(book);
        authorRepo.save(author);
        return "Book added successfully";
    }
}
