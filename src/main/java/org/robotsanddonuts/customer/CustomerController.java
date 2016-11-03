package org.robotsanddonuts.customer;

import javax.validation.Valid;

import org.robotsanddonuts.beans.Customer;
import org.robotsanddonuts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
	

	@GetMapping("/customers")
	public String getCustomers(Model model) {
		model.addAttribute("customers", customerRepo.findAll());
		return "customer/customers";
	}
	
	@GetMapping("/customer/{id}")
	public String customer(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Customer c = customerRepo.findOne(id);
		model.addAttribute("customer", c);
		return "customer/customer_detail";
	}

	@GetMapping("/customer/{id}/edit")
	public String customerEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Customer c = customerRepo.findOne(id);
		model.addAttribute("customer", c);
		return "customer/customer_edit";
	}

	@PostMapping("/customer/{id}/edit")
	public String customerEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Customer customer,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "customer/customer_edit";
		} else {
			customerRepo.save(customer);
			return "redirect:/customer/" + customer.getId();
		}
	}
	
	@GetMapping("/customer/{id}/delete")
	public String customerDelete(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Customer c = customerRepo.findOne(id);
		model.addAttribute("customer", c);
		return "customer/customer_delete";
	}

	@PostMapping("/customer/{id}/delete")
	public String customerDeleteSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Customer customer,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "customer/customers";
		} else {
			customerRepo.delete(customer);
			return "redirect:/customers";
		}
	}

	@GetMapping("/customer/create")
	public String customerCreate(Model model) {
		model.addAttribute(new Customer());
		return "customer/customer_create";
	}

	@PostMapping("/customer/create")
	public String customerCreate(@ModelAttribute @Valid Customer customer, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "customer/customer_create";
		} else {
			customerRepo.save(customer);
			return "redirect:/customers";
		}

	}

	
	
	
	
	
}
