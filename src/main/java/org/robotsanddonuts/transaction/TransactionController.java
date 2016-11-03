package org.robotsanddonuts.transaction;

import org.robotsanddonuts.beans.Transaction;
import org.robotsanddonuts.repository.CustomerRepository;
import org.robotsanddonuts.repository.ProductRepository;
import org.robotsanddonuts.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping("/transaction/{id}/edit")
	public String transactionEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Transaction t = transactionRepo.findOne(id);
		model.addAttribute("transaction", t);
		model.addAttribute("customers", customerRepo.findAll());
		model.addAttribute("products", productRepo.findAll());
		return "transaction/transaction_edit";
	}
}
