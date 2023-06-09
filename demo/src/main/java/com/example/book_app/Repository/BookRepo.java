package com.example.book_app.Repository;

import com.example.book_app.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    Book findByBookName(String bookName);
}
