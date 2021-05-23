package com.book.service;  
import java.util.ArrayList; 
 
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.book.exception.BookNotFoundException;
import com.book.model.Books;  
import com.book.repository.BooksRepository;  

//defining the business logic  
@Service  
public class BooksService   
{  
	@Autowired 
	BooksRepository booksRepository;  
	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Books> getAllBooks()   
	{  
		List<Books> books = new ArrayList<Books>();  
		booksRepository.findAll().forEach(books1 -> books.add(books1));  
		return books;  
	}  
	
	//getting a specific record by using the method findById() of CrudRepository  
	public Books getBooksById(int bookId)   
	{  
		Optional<Books> book = booksRepository.findById(bookId);
		if(!book.isPresent()) {
			throw new BookNotFoundException("bookId" + bookId );
		}
		
		return book.get();
	}  
	//creating a new book
	
	public Books createBook(Books books) {
		return booksRepository.save(books);
	}
	
	
	//updating a book  
	public void update(int bookId, Books books)   
	{  
		Optional<Books> book = booksRepository.findById(bookId);
		if(!book.isPresent()) {
			throw new BookNotFoundException("id-" + bookId);
		}
		books.setId(bookId);
		booksRepository.save(books);
	}
	
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int bookId)   
	{  
		Optional<Books> deletebook = booksRepository.findById(bookId);
		if(!deletebook.isPresent()) { 
			throw new BookNotFoundException("id-" + bookId);
		}
		booksRepository.deleteById(bookId);
	}

	public void updateClassification(int bookId, Books book) {
		Optional<Books> updateBook = booksRepository.findById(bookId);
		if(!updateBook.isPresent()) {
			throw new BookNotFoundException("id-" + bookId);
		}
		updateBook.get().setClassification(book.getClassification());
		booksRepository.save(updateBook.get());
	}  
}  