package com.sherwin.infrastructure.customer.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sherwin.domain.customer.Customer;
import com.sherwin.domain.customer.CustomerGateway;
import com.sherwin.infrastructure.customer.CustomerJpaEntity;

@Service
public class CustomerSqlGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;

    public CustomerSqlGateway(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
       
        final CustomerJpaEntity customerToJpa = new CustomerJpaEntity(
            customer.getId().getValue(),
            customer.getSocialReason(),
            customer.getFantasyName(),
            customer.getIdentity().isPresent() ? customer.getIdentity().get().getIdentity() : null,
            customer.getIdentity().isPresent() ? customer.getIdentity().get().getType() : null,
            customer.getPhone(),
            customer.getIsActive()
        );

        this.customerRepository.save(customerToJpa);
        return customer;
    }

    @Override
    public Customer findByDocument(String document) {
       final Optional<CustomerJpaEntity> customerObj = Optional.ofNullable(this.customerRepository.findByDocument(document));
       final Customer getCustomer = customerObj.stream().map(CustomerJpaEntity::toAggregate).findFirst().orElseThrow();
       return getCustomer;
    }

    @Override
    public Customer findById(String id) {
       final Optional<CustomerJpaEntity> customerObj = this.customerRepository.findById(id);
       final Customer getCustomer = customerObj.stream().map(CustomerJpaEntity::toAggregate).findFirst().orElseThrow();
       return getCustomer;
    }

    @Override
    public List<Customer> findAll() {
       final List<CustomerJpaEntity> customerJpaList = this.customerRepository.findAll();
       final List<Customer> customerList = customerJpaList.stream().map(CustomerJpaEntity::toAggregate).toList();
       
       return customerList;
    }
}
