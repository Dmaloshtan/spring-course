package org.home.springdemo.controller;

import org.home.springdemo.dao.CustomerDAO;
import org.home.springdemo.entity.Customer;
import org.home.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model model){

       List<Customer> customers = customerService.getCustomers();

       model.addAttribute("customers",customers);

        return "list-customers";
    }


}
