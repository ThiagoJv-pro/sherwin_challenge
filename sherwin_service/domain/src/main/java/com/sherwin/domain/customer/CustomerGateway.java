package com.sherwin.domain.customer;

import java.util.List;

public interface CustomerGateway {
    
    public Customer create(Customer client);

    public Customer findByDocument(String document);

    public Customer findById(String id);

    public List<Customer> findAll();
}
