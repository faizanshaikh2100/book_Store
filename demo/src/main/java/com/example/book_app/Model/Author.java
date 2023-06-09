package com.example.book_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//com
//        └── yourcompany
//        └── yourproject
//        ├── controller
//        │   └── ...
//        ├── dto
//        │   └── ...
//        ├── model
//        │   ├── Author.java
//        │   ├── Book.java
//        │   ├── Management.java
//        │   ├── PublishInfo.java
//        │   └── BookPublishing.java
//        ├── repository
//        │   ├── AuthorRepository.java
//        │   ├── BookRepository.java
//        │   ├── ManagementRepository.java
//        │   ├── PublishInfoRepository.java
//        │   └── BookPublishingRepository.java
//        ├── service
//        │   ├── AuthorService.java
//        │   ├── BookService.java
//        │   ├── ManagementService.java
//        │   ├── PublishInfoService.java
//        │   └── BookPublishingService.java
//        └── utils
//        └── ...

//        One author can have many books (One-to-Many relationship).

//        One author needs approval from one management (One-to-One relationship).


//        One management approves multiple authors (One-to-Many relationship).

//        Book and PublishInfo:

//        One book has one publishing information (One-to-One relationship).
//        Book and BookPublishing:

//        One book can be published in multiple ways (Many-to-Many relationship).
//        One publishing method can be used for multiple books (Many-to-Many relationship).
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;
    private String password;
    private String email;


    @OneToMany(cascade = CascadeType.ALL)
    List<Book>bookList = new ArrayList<>();

}
