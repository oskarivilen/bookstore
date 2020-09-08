package com.example.bookstore.web;





import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BookController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		
		return "index";
	}
}
