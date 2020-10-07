package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;
import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Crime"));
			
			
			brepository.save(new Book(1, "Way of Kings", "Brandon Sanderson", 2002, "f24fw", 15, crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book(2, "Leviathan Awakes", "James S.A Corey", 2011, "43Ks3", 20, crepository.findByName("Scifi").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("oskari", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user3 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
