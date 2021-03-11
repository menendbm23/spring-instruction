package com.prs.web;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Request;
import com.prs.db.RequestRepo;


@CrossOrigin
@RestController
@RequestMapping("/api/requests")

public class RequestController {

	@Autowired
	private RequestRepo requestRepo;

	@GetMapping("/")
	public List<Request> getAll() {
		return requestRepo.findAll();
	}

	@GetMapping("{id}")
	public Request getById(@PathVariable int id) {
		return requestRepo.findById(id).get();
	}

	@GetMapping("/list-review/{id}")
	public List<Request> listReview(@PathVariable int id) {
		return requestRepo.findByUserId(id);

	}

	@PostMapping("/")
	public Request create(@RequestBody Request request) {
		request.setStatus("New");
		LocalDateTime currentDate = LocalDateTime.now();
		request.setSubmittedDate(currentDate);
		requestRepo.save(request);
		return requestRepo.save(request);
		
	}

	@PutMapping("/")
	public Request request(@RequestBody Request request) {
		return requestRepo.save(request);
	}

	@PutMapping("/submit-review")
	public Request status(@RequestBody Request request) {
		String status = "";
		if (request.getTotal() <= 50) {
			status = "approved";
		
		} else {
			status = "review";
		}
		
		LocalDateTime currentDate = LocalDateTime.now();
		request.setSubmittedDate(currentDate);

		//save
		requestRepo.save(request);
		return request;
	}
	
	@PutMapping("/approve")
	public Request approve(@RequestBody Request request) {
		
		request.setStatus("Approved");
		requestRepo.save(request);
		
		return request;
	}
	
	@PutMapping("/reject")
	public Request rejected(@RequestBody Request request) {
		request.setStatus("Rejected");
		requestRepo.save(request);
		
		return request;
	}

	@DeleteMapping("/{id}")
	public Request delete(@PathVariable int id) {
		Optional<Request> request = requestRepo.findById(id);
		if (request.isPresent()) {
			requestRepo.delete(request.get());
		} else {
			System.out.println("Delete Error - Request Error");
		}
		return request.get();
	}
}
