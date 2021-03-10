package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.prs.db.UserRepo;
import com.prs.db.VendorRepo;
import com.prs.business.User;
import com.prs.business.Vendor;

@CrossOrigin
@RestController
@RequestMapping("/api/vendors")
public class VendorController {

	@Autowired
	private VendorRepo vendorRepo;
	
	@GetMapping("/")
	public List<Vendor> getAll() {
		return vendorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Vendor getById(@PathVariable int id) {
		return vendorRepo.findById(id).get();
	}
	
	@PostMapping("/")
	public Vendor create(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	@PutMapping("/")
	public Vendor update(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	@DeleteMapping("/{id}")
	public Vendor delete(@PathVariable int id) {
		Optional<Vendor> vendor = vendorRepo.findById(id);
		if (vendor.isPresent()) {
			vendorRepo.delete(vendor.get());
		}
		else {
			System.out.println("Delete Error - vendor not found for id: "+id);
		}
		return vendor.get();
	}
	

}
