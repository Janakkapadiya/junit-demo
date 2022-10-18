package com.junitMokito.example.junit.mokiito.repo;

import com.junitMokito.example.junit.mokiito.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN TRUE ELSE FALSE END FROM Books b WHERE b.id = ?1")
    boolean checkIfBookExistById(int id);
}
