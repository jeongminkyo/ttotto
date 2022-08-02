package com.landvibe.ttotto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/health-check")
	public String healthCheck() {
		return "Hello Onul!!";
	}
}
