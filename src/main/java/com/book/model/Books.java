/**
 * 
 */
package com.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



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
	@Column(name="BookId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	@Size(min=5, message="Name should have atleast 5 characters")
	private String name;

	@Column
	@Size(max=250,message="Description should not have more than 250 characters")
	private String description;

	@Column
	private String author;

	@Column
	@DecimalMin(value = "0.01",message="Price should not be empty")
	private Double price;

	@Column(nullable = false)
	@Pattern(regexp = "[A-Z]{3}-[0-9]{4}",message = "ISBN should follow the pattern XXX-9999. First 3 places\n"
			+ "should be alphabets, followed by ‘-’ and then by 4 digits. Eg: FIC-0001")
	private String isbn;

	@Enumerated(EnumType.STRING)
	private Classification classification;


	public enum Classification{
		FICTION, COMIC, ADVENTURE, TRAVEL, HEALTH, MYSTERY ;
	}


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
	public Classification getClassification() {
		return classification;
	}
	public void setClassification(Classification classification) {
		this.classification = classification;
	}


}
