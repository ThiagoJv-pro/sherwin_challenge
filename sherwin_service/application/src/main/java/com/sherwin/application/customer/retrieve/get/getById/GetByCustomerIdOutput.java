package com.sherwin.application.customer.retrieve.get.getById;

import java.util.Optional;

import com.sherwin.domain.customer.Customer;
import com.sherwin.domain.customer.Identity;

public record GetByCustomerIdOutput(
    String id,
    String socialReason,
    String fantasyName,
    Optional<Identity> identity,
    String phone,
    Boolean isActive

) {
    public static GetByCustomerIdOutput from(Customer client) {
        return new GetByCustomerIdOutput(
            client.getId().getValue(), 
            client.getSocialReason(), 
            client.getFantasyName(), 
            client.getIdentity(), 
            client.getPhone(), 
            client.getIsActive()
        );
    }
    
}
