
package com.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Book;


@RestController
public class BookController {
	@Autowired
	 private BookService bookService;
	
	@GetMapping("/books")
	private List<Book> getBooks()
	{
		List<Book> findAll = bookService.findAll();
		
		
		return findAll;
	}
	
	@GetMapping("/books/{id}")
	private Book getBook(@PathVariable("id")int id)
	{
		Book findbyId = bookService.findbyId(id);
		return findbyId;
		
	}
	
	@DeleteMapping("/books/{id}")
	private Book deleteBook(@PathVariable("id")int id)
	{
		Book delete = bookService.Delete(id);
		return delete;
	}
	
	@PostMapping("/books")
	private Book addBook(@RequestBody Book book)
	{
		Book insert = this.bookService.insert(book);
		System.out.println("books");
		return insert;
	}
	
	@PutMapping("/books/{id}")
	private Book updateBook(@RequestBody Book book , @PathVariable("id")int id)
	{
		bookService.update(book,id);
		return book;
	}

}
