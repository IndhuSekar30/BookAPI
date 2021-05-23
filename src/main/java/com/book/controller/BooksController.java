package com.book.controller;  

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.book.model.Books;
import com.book.service.BooksService;

import io.swagger.models.HttpMethod;  

//Books Controller Class
@RestController
public class BooksController   
{  
	@Autowired
	BooksService booksService;

	//creating a get mapping which retrieves all of the books details from the database   
	@GetMapping("/books")  
	public ResponseEntity<Object> getAllBooks()   
	{  
		return ResponseEntity.ok(booksService.getAllBooks());
	}  


	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/book/{id}")  
	public ResponseEntity<Books> getBooks(@PathVariable("id") int bookid)   
	{  
		return ResponseEntity.ok(booksService.getBooksById(bookid));  
	}  


	//creating post mapping that post the book detail in the database  
	@PostMapping("/book")  
	public ResponseEntity<Books> createBook(@Valid @RequestBody Books books)
	{  
		Books createdBook= booksService.createBook(books);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
	}  


	//creating put mapping that updates the book detail   
	@PutMapping("/book/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int bookId, @Valid @RequestBody Books book)   
	{  
		booksService.update(bookId,book);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Updated Succesfully");
	}

	@PatchMapping("/book/{id}")  
	private ResponseEntity<String> updateClassification(@PathVariable("id") int bookId, @Valid @RequestBody Books book)   
	{  
		booksService.updateClassification(bookId,book);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Classification Updated succesfully");
	}

	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/book/{id}")  
	public ResponseEntity<Books> deleteBook(@PathVariable("id") int bookid)   
	{  
		booksService.delete(bookid);
		return ResponseEntity.ok().build();
	}  
}