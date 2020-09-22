package com.example.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





@Entity
public class Book {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	 @ManyToOne
	    @JoinColumn(name = "categoryid")
	    private Category category;
	
	 public Book() {}
	 
	 public Book(long id, String title, String author, int year, String isbn, double price, Category category) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.year = year;
			this.isbn = isbn;
			this.price = price;
			this.category = category;
		}
	 public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + " category =" + this.getCategory() + "]";
		else 
			return 
					"Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + "]";
	}

}
