package com.example;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookProductRepository extends JpaRepository<BookProduct, Long>{
    List<BookProduct> findByBookId(Long bookId);
}
