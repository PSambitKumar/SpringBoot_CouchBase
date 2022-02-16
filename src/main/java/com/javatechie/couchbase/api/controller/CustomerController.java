package com.javatechie.couchbase.api.controller;

import com.javatechie.couchbase.api.model.Customer;
import com.javatechie.couchbase.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostConstruct
    public void saveCustomers() {
        repository.saveAll(Stream
                .of(new Customer(1, "Dilip", new String[] { "Odisha", "Koraput" }),
                        new Customer(2, "Nitish", new String[] { "Odisha", "Bhadrak" }),
                        new Customer(3,"Sambit",new String[] {"Odisha", "Salipur"}),
                        new Customer(4,"Hrusi",new String[] {"Odisha", "Balesore"}))
                .collect(Collectors.toList()));
    }

    @GetMapping("/ViewAllCustomers")
    public Iterable<Customer> viewCustomers() {
        return repository.findAll();
    }
}
