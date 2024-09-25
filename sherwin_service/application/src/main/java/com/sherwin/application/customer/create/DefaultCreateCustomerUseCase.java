package com.sherwin.application.customer.create;


import com.sherwin.domain.customer.Customer;
import com.sherwin.domain.customer.CustomerGateway;

public class DefaultCreateCustomerUseCase extends CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public DefaultCreateCustomerUseCase(final CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CreateCustomerOutput execute(CreateCustomerCommand aCommand) {
        return CreateCustomerOutput.from(create(aCommand));
    }


    public Customer create(final CreateCustomerCommand aCommand) {

        final var customer = Customer.createCustomer(
            aCommand.socialReason(),
            aCommand.fantasyName(), 
            aCommand.identity(), 
            aCommand.phone(), 
            aCommand.isActive()
        );
        
        return customerGateway.create(customer);
    }
    
}
