package org.home.springdemo.dao;

import org.home.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
}
