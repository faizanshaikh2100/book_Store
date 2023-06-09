package com.example.book_app.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApporvalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int approvalId;
    private int approvedById;

    private int bookId;
    private int authorId;
}
