package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Credit;
import com.bmdb.business.Movie;
import com.bmdb.db.CreditRepo;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/credits")
public class CreditController {
	
	@Autowired
	private CreditRepo creditRepo;
	
	@GetMapping("/")
	public List<Credit> getAll() {
		return creditRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Credit getById(@PathVariable int id) {
		return creditRepo.findById(id).get();
	}
	
	@PostMapping("/")
	public Credit create(@RequestBody Credit credit) {
		return creditRepo.save(credit);

	}
	
	@PutMapping("/")
	public Credit update(@RequestBody Credit credit) {
		return creditRepo.save(credit);

	}
	
	@DeleteMapping("/{id}")
	public Credit delete(@PathVariable int id) {
		Optional<Credit> credit = creditRepo.findById(id);
		if (credit.isPresent()) {
			creditRepo.delete(credit.get());
		}
		else {
			System.out.println("Delete Error - credit not found for id: "+id);
		}
		return credit.get();

	}
	
	
	
}
