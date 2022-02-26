package com.javatechie.couchbase.api.controller;

import com.javatechie.couchbase.api.model.Customer;
import com.javatechie.couchbase.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("Home")
    public String addCustomer(Model model){
        model.addAttribute("addCustomer", new Customer());
        return "Home";
    }

    @PostMapping("saveCustomer")
    public String saveCustomer(Customer customer){
        System.out.println(customer);
        repository.save(customer);
        return "redirect:/Home";
    }

    @ResponseBody
    @GetMapping("ViewCustomers")
    public List<Customer> view(){
        List<Customer> list = (List<Customer>) repository.findAll();
        return list;
    }
}
