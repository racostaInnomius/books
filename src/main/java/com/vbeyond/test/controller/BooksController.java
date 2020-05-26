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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Api(value="Book Management System", description="Operations pertaining to book in Book Management System")
public class BooksController {
	
	@Autowired
	BooksRepository booksrepository;
	
	// Get All Books
	@ApiOperation(value = "View a list of available books", response = List.class)
	@GetMapping("/books")
	public List<Book> getAllNotes() {
	    return booksrepository.findAll();
	}

	// Create a new Book
	@ApiOperation(value = "Create a new book register", response = Book.class)
	@PostMapping("/book")
	public Book createNote(@RequestBody Book book) {
	    return booksrepository.save(book);
	}
	
	// Get a Single Book
	@ApiOperation(value = "Retrieve a single book by id", response = Book.class)
	@GetMapping("/book/{id}")
	public Book getNoteById(@PathVariable(value = "id") Long noteId) {
	    return booksrepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Book", "id", noteId));
	}
	
	// Get a Single by title
	@ApiOperation(value = "Retrieve a single book by title", response = Book.class)
	@GetMapping("/book/title/{title}")
	public Book getEmplyeeByName(@PathVariable(value = "title") String title) {
	    return (Book) booksrepository.findByTitle(title)
	            .orElseThrow(() -> new ResourceNotFoundException("Book", "id", title));
	}
	
	// Update a book
	@ApiOperation(value = "Update a single book with an id", response = Book.class)
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
