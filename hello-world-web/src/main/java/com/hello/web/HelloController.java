package com.hello.web;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/hello")
public class HelloController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World!!";
	}

	// using a requestParameter....?name=bob
	@GetMapping("")
	public String sayHello(@RequestParam String name) {
		return "Hello "+name+"!!";
	}
}
