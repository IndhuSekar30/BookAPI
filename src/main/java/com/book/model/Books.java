/**
 * 
 */
package com.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author IndhuSekar
 *
 */
	//mark class as an Entity   
	@Entity  
	//defining class name as Table name  
	@Table  
	public class Books 
	{  
		//Defining book id as primary key  
		@Id  
		@Column

		 private int id=0;
		
		 @Column
	  	 private String name;
		 
		 @Column
	  	 private String description;
		 
		 @Column
	  	 private String author;
		 
		 @Column
	   	 private double price=0;
		 
		 @Column
	  	 private String isbn;
		 
	  	 public enum Classification{
	  		FICTION, COMIC, ADVENTURE, TRAVEL, HEALTH, MYSTERY ;
	  	 }
	  	 
	  	@Enumerated(EnumType.ORDINAL)
	  	private Classification classification;
	  	
	  	 /**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		/**
		 * @return the author
		 */
		public String getAuthor() {
			return author;
		}
		/**
		 * @param author the author to set
		 */
		public void setAuthor(String author) {
			this.author = author;
		}
		/**
		 * @return the price
		 */
		public double getPrice() {
			return price;
		}
		/**
		 * @param price the price to set
		 */
		public void setPrice(double price) {
			this.price = price;
		}
		/**
		 * @return the isbn
		 */
		public String getIsbn() {
			return isbn;
		}
		/**
		 * @param isbn the isbn to set
		 */
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		
		  
		  
}
