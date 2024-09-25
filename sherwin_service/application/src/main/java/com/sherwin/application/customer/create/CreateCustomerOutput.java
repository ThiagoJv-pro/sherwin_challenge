package com.sherwin.application.customer.create;

import com.sherwin.domain.customer.Customer;


public record CreateCustomerOutput(
    String id
) {
    public static CreateCustomerOutput from(final Customer client){
        return new CreateCustomerOutput(client.getId().getValue());
    }
}
