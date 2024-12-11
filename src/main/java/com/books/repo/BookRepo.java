package com.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
		
}