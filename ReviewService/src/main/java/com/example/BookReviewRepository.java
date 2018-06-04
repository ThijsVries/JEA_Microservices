package com.example;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookReviewRepository extends JpaRepository<BookReview, Long>{
    List<BookReview> findByBookId(Long bookId);
}
