package com.sherwin.application.customer.retrieve.get.getById;


import com.sherwin.domain.customer.Customer;
import com.sherwin.domain.customer.CustomerGateway;
import com.sherwin.domain.customer.CustomerId;

public class DefaultGetByCustomerIdUseCase extends GetByCustomerIdUseCase{

    private final CustomerGateway clientGateway;
    

    public DefaultGetByCustomerIdUseCase(final CustomerGateway clientGateway) {
        this.clientGateway = clientGateway;
    }


    @Override
    public GetByCustomerIdOutput execute(final GetByCustomerIdCommand aCommand) {
       
        final CustomerId id = aCommand.id();
        final Customer getCustomer = this.clientGateway.findById(id.getValue());
        return GetByCustomerIdOutput.from(getCustomer);
    }
    
}
