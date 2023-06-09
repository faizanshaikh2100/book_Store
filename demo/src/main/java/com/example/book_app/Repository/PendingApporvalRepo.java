package com.example.book_app.Repository;


import com.example.book_app.Model.PendingApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingApporvalRepo extends JpaRepository<PendingApproval, Integer> {
    
}
