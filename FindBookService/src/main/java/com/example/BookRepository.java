package com.example;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface BookRepository extends JpaRepository<Book, Long>{
    
    List<Book> findByTitle(String title);
}
