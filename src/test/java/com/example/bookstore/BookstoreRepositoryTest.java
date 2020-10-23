package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;




@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Way of Kings");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Brandon Sanderson");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book(3, "Shining", "Stephen King", 1975, "gew2", 10, new Category("Horror"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
    @Test
    public void deleteBook() {
    	Book book = new Book(3, "Shining", "Stephen King", 1975, "gew2", 10, new Category("Horror"));
    
		repository.delete(book);
		assertThat(book.getId()).isNotNull();
		
	}

}