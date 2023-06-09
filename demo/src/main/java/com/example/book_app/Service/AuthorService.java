package com.example.book_app.Service;


import com.example.book_app.Model.Author;
import com.example.book_app.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepository;
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author added successfully";
    }

    public Author getAuthor(int id) {
        return authorRepository.findById(id).orElse(new Author());
    }


    public String updateAuthor(Author newAuthor) {
        Author oldAuthor;
        if(newAuthor.getAuthorId()!=0){
            oldAuthor = authorRepository.findById(newAuthor.getAuthorId()).get();
        }
     else {
            oldAuthor = authorRepository.findByEmail(newAuthor.getEmail().trim());
        }
        if(newAuthor.getAuthorName()!=null && !(newAuthor.getAuthorName().equals("")))
            oldAuthor.setAuthorName(newAuthor.getAuthorName());
        if(newAuthor.getEmail()!=null&& !(newAuthor.getEmail().equals("")))
            oldAuthor.setEmail(newAuthor.getEmail());
        if(newAuthor.getBookList()!=null)
            oldAuthor.setBookList(newAuthor.getBookList());
        if(newAuthor.getPassword()!=null)
            oldAuthor.setPassword(newAuthor.getPassword());
        authorRepository.save(oldAuthor);

        return "Author updated successfully";
    }
    }