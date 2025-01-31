package com.txn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.txn.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
		
}