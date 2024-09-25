package com.sherwin.application.customer.retrieve.list;

import java.util.List;

import com.sherwin.domain.customer.Customer;
import com.sherwin.domain.customer.CustomerGateway;

public class DefaultFindAllCustomersUseCase extends FindAllCustomersUseCase {

    private final CustomerGateway customerGateway;

    public DefaultFindAllCustomersUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<FindAllCustomersOutput> execute() {
       final List<Customer> findAllCustomers = this.customerGateway.findAll();
       final List<FindAllCustomersOutput> customerList = findAllCustomers.stream()
        .map(fn -> new FindAllCustomersOutput(
            fn.getId().getValue(), 
            fn.getSocialReason(), 
            fn.getFantasyName(), 
            fn.getIdentity(), 
            fn.getPhone(), 
            fn.getIsActive()
        )).toList();
        return customerList;
    }
    
}
