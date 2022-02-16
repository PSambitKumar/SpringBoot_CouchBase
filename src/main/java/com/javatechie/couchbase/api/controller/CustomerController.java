package com.javatechie.couchbase.api.controller;

import com.javatechie.couchbase.api.model.Customer;
import com.javatechie.couchbase.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostConstruct
    public void saveCustomers() {
        try {
            repository.saveAll(Stream
                    .of(new Customer(01, "Dilip", new String[] { "Odisha", "Koraput" }),
                            new Customer(02, "Nitish", new String[] { "Odisha", "Bhadrak" }),
                            new Customer(03,"Sambit",new String[] {"Odisha", "Salipur"}),
                            new Customer(04,"Hrusi",new String[] {"Odisha", "Balesore"}))
                    .collect(Collectors.toList()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/ViewAllCustomers")
    public Iterable<Customer> viewCustomers() {
        return repository.findAll();
    }

    @GetMapping("/Delete{id}")
    public Iterable<Customer> deleteById(@PathVariable("id") int id) {
        Iterable<Customer> iterable = null;
        try {
            repository.deleteById(id);
            iterable = repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iterable;
    }
}
