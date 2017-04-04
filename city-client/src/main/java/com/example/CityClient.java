package com.example;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("city-server")
	public interface CityClient {  
	    
		@GetMapping(value = "/cities")
	    Collection<String> getCities();


}
