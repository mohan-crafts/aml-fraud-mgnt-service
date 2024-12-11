package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.entity.Book;
import com.books.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired BooksService booksService;
	
	@GetMapping("")
	public ResponseEntity<List<Book>> getBooks() {
		return ResponseEntity.ok(booksService.getAllBooks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Long bookID) {
		return ResponseEntity.ok(booksService.getBookById(bookID));
	}
	
	@PostMapping("")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		
		return ResponseEntity.ok(booksService.createBook(book));
	}
	
	@PutMapping("")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		
		return ResponseEntity.ok(booksService.createBook(book));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable("id") Long bookId) {
		booksService.deleteBook(bookId);
		return ResponseEntity.ok(true);
	}
}