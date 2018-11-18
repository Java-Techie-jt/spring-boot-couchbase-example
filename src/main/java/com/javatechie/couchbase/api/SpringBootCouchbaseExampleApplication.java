package com.javatechie.couchbase.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.couchbase.api.model.Customer;
import com.javatechie.couchbase.api.repository.CustomerRepository;

@SpringBootApplication
@RestController
public class SpringBootCouchbaseExampleApplication {

	@Autowired
	private CustomerRepository repository;

	@PostConstruct
	public void initCustomerRepo() {
		repository.saveAll(Stream
				.of(new Customer(111, "John", new String[] { "Bangalore", "Marathali" }),
						new Customer(222, "Pitter", new String[] { "Hyderabad", "SR Nagar" }))
				.collect(Collectors.toList()));
	}

	@GetMapping("/fetchAllCustomers")
	public Iterable<Customer> getAll() {
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCouchbaseExampleApplication.class, args);
	}
}
