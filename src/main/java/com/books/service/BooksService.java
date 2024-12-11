package com.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.entity.Book;
import com.books.repo.BookRepo;

@Service
public class BooksService {
	
	@Autowired BookRepo bookRepo;
	
	public List<Book> getAllBooks() {
		
		return bookRepo.findAll();
	}
	
	public Book getBookById(Long id) {
		
		return bookRepo.findById(id).get();
	}
	
	public Book createBook(Book book) {
		
		return bookRepo.save(book);
	}
	
	public Book updateBook(Book book) {
		
		return bookRepo.save(book);
	}
	
	public void deleteBook(Long bookId) {
		bookRepo.deleteById(bookId);
	}
}