package com.vbeyond.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vbeyond.test.entities.Book;
import com.vbeyond.test.exception.ResourceNotFoundException;
import com.vbeyond.test.repository.BooksRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BooksController {
	
	@Autowired
	BooksRepository booksrepository;
	
	// Get All Books
	@GetMapping("/books")
	public List<Book> getAllNotes() {
	    return booksrepository.findAll();
	}

	// Create a new Book
	@PostMapping("/book")
	public Book createNote(@RequestBody Book employee) {
	    return booksrepository.save(employee);
	}
	
	// Get a Single Book
	@GetMapping("/book/{id}")
	public Book getNoteById(@PathVariable(value = "id") Long noteId) {
	    return booksrepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Book", "id", noteId));
	}
	
	// Get a Single by title
	@GetMapping("/book/title/{title}")
	public Book getEmplyeeByName(@PathVariable(value = "title") String title) {
	    return (Book) booksrepository.findByTitle(title)
	            .orElseThrow(() -> new ResourceNotFoundException("Book", "id", title));
	}
	
	// Update a book
	@PutMapping("/book/{id}")
	public Book updateNote(@PathVariable(value = "id") Long id, @RequestBody Book bookDetails) {
		Book book = booksrepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
		
		book.setTitle(bookDetails.getTitle());
		book.setAuthor(bookDetails.getAuthor());
		book.setCover(bookDetails.getCover());

	    return booksrepository.save(book);
	}
}
