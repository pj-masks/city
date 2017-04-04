package com.example;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityServerController {
	
	@GetMapping("/cities")
	public Collection<String> get() {
		return Stream.of("New Delhi", "London", "Berlin", "Washington D.C").collect(Collectors.toList());
	}

}
