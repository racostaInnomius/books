package com.vbeyond.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vbeyond.test.entities.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>{
	
	public <T> Optional<T> findByTitle(String name);

}
