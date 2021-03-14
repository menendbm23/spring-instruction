package com.prs.web;

import java.text.NumberFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import com.prs.business.LineItem;
import com.prs.business.Product;
import com.prs.business.Request;
import com.prs.business.User;
import com.prs.db.LineItemRepo;
import com.prs.db.RequestRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/lineitems")

public class LineItemController {

	@Autowired
	private LineItemRepo lineItemRepo;
	@Autowired
	private RequestRepo requestRepo;

	@GetMapping("/")
	public List<LineItem> getAll() {
		return lineItemRepo.findAll();
	}

	@GetMapping("/lines-for-pr/{id}")
	public List<LineItem> linesForPr(@PathVariable int id) {
		return lineItemRepo.findByRequestId(id);
	}

	@GetMapping("/{id}")
	public LineItem getById(@PathVariable int id) {
		return lineItemRepo.findById(id).get();
	}

	@PostMapping("/")
	public LineItem create(@RequestBody LineItem lineItem) {
		lineItemRepo.save(lineItem);
		recalculateTotal(lineItem.getRequest());
		// return the line item
		return lineItem;
	}

	public void recalculateTotal(Request request) {
		List<LineItem> lis = lineItemRepo.findByRequestId(request.getId());
		double newTotal = 0.0;
		// get lines by request
		// loop through lines
		for (LineItem lineItem: lis) {
			newTotal += lineItem.getQuantity() * lineItem.getProduct().getPrice();
		}
			// calculate line total lit = li.quantity * li.getProduct().getprice()
			// add line total to recalculatetotal
		// set new total in request
			request.setTotal(newTotal);
		// save Request
				 requestRepo.save(request);
	}

	@PutMapping("/")
	public LineItem update(@RequestBody LineItem lineItem) {
		lineItemRepo.save(lineItem);
		recalculateTotal(lineItem.getRequest());
		return lineItem;
	}
	

	@DeleteMapping("/{id}")
	public LineItem delete(@PathVariable int id) {
		Optional<LineItem> lineItem = lineItemRepo.findById(id);
		if (lineItem.isPresent()) {
			lineItemRepo.delete(lineItem.get());
			recalculateTotal(lineItem.get().getRequest());
		} else {
			System.out.println("Delete error - Line item not found");
		}
		return lineItem.get();
	}
}
