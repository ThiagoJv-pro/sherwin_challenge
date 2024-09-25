package com.sherwin.application.customer.retrieve.get.getByIdentity;

import com.sherwin.domain.customer.Customer;
import com.sherwin.domain.customer.CustomerGateway;

public class DefaultGetByCustomerDocumentUseCase extends GetByCustomerDocumentUseCase{

    private final CustomerGateway clientGateway;
    

    public DefaultGetByCustomerDocumentUseCase(final CustomerGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    @Override
    public GetByCustomerDocumentOutput execute(GetByCustomerDocumentCommand aCommand) {
        final String identity = aCommand.document();
        final Customer getCustomer = this.clientGateway.findByDocument(identity);
        return GetByCustomerDocumentOutput.from(getCustomer);
    }
    
}
