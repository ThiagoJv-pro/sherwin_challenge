package com.sherwin.infrastructure.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sherwin.infrastructure.customer.model.CreateClientRequest;
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping(value = "customer")
public interface CustomerApi {
    
    @PostMapping(value = "/create")
    ResponseEntity<?> createClient(@RequestBody CreateClientRequest data);

    @GetMapping(value = "/find/id/{id}")
    ResponseEntity<?> findByCustomerId(@PathVariable String id);

    @GetMapping(value = "/find/document/{document}")
    ResponseEntity<?> findByCustomerDocument(@PathVariable String document);

    @GetMapping(value = "/find/all")
    ResponseEntity<?> findAllCustomers();

}
