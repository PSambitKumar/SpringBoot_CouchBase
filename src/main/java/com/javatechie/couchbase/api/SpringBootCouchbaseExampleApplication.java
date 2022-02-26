package com.javatechie.couchbase.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringBootCouchbaseExampleApplication {

//	@Autowired
//	private CustomerRepository repository;
//
//	@PostConstruct
//	public void initCustomerRepo() {
//		repository.saveAll(Stream
//				.of(new Customer(1, "Dilip", new String[] { "Odisha", "Koraput" }),
//						new Customer(2, "Nitish", new String[] { "Odisha", "Bhadrak" }),
//						new Customer(3,"Sambit",new String[] {"Odisha", "Salipur"}))
//				.collect(Collectors.toList()));
//	}
//
//	@GetMapping("/fetchAllCustomers")
//	public Iterable<Customer> getAll() {
//		return repository.findAll();
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCouchbaseExampleApplication.class, args);
	}
}
