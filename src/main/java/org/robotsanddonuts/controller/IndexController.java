package org.robotsanddonuts.controller;

import javax.validation.Valid;

import org.robotsanddonuts.beans.Customer;
import org.robotsanddonuts.beans.Product;
import org.robotsanddonuts.repository.CustomerRepository;
import org.robotsanddonuts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
		
	@GetMapping("")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/home")
	public String home(Model model){
		return "home";
	}
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	

}
