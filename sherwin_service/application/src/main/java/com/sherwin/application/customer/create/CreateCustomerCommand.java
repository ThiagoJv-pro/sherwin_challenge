package com.sherwin.application.customer.create;


public record CreateCustomerCommand (
    String socialReason,
    String fantasyName,
    String identity,
    String phone,
    Boolean isActive
) {

    public static CreateCustomerCommand createCustomer(
        String socialReason,
        String fantasyName,
        String identity,
        String phone,
        Boolean isActive
    ) {
       return new CreateCustomerCommand(
            socialReason, 
            fantasyName, 
            identity,
            phone, 
            isActive
        );
    }
    
}
