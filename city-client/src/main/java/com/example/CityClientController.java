package com.example;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CityClientController {
	
	@Autowired
	org.springframework.cloud.client.discovery.DiscoveryClient client;
	
	/*private final CityClient cityClient;
	
	@Autowired
	public CityClientController(final CityClient cityClient){
		this.cityClient = cityClient;
	}
	*/
	RestTemplate restTemplate = new RestTemplate();
	@GetMapping("/cities")
	public Collection<String> get(){
		org.springframework.cloud.client.ServiceInstance serviceInstance =
				  client.getInstances("city-service")
				        .stream()
				        .findFirst()
				        .orElseThrow(() -> new RuntimeException("city-service not found"));
		String url = serviceInstance.getUri().toString() + "/cities";
		return restTemplate.getForObject(url, Collection.class);
		
		//return cityClient.getCities();
	}

}
