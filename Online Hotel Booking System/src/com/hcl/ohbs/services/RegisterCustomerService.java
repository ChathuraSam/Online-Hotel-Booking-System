package com.hcl.ohbs.services;

import java.sql.SQLException;

import com.hcl.ohbs.dao.CustomerDAO;
import com.hcl.ohbs.entities.Customer;

public class RegisterCustomerService {

    public boolean registerCustomer(String firstName, String lastname, String phone, String address, String email, String username, String password, String confirmPassword) {
        CustomerDAO c = new CustomerDAO();
        boolean a = c.registerCustomer(new Customer(firstName, lastname, phone, address, email, username, password));
        
        return a;
    }
}
