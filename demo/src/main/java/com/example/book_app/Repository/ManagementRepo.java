package com.example.book_app.Repository;

import com.example.book_app.Model.Author;
import com.example.book_app.Model.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepo extends JpaRepository<Management,Integer> {
}
