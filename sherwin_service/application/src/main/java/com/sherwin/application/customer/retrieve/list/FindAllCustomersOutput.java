package com.sherwin.application.customer.retrieve.list;

import java.util.Optional;

import com.sherwin.domain.customer.Customer;

public record FindAllCustomersOutput(
    String id,
    String socialReason,
    String fantasyName,
    Optional<?> identity,
    String phone,
    Boolean isActive
) {
    public FindAllCustomersOutput from(final Customer customer){
        return new FindAllCustomersOutput(
            customer.getId().getValue(), 
            customer.getSocialReason(), 
            customer.getFantasyName(), 
            customer.getIdentity(), 
            customer.getPhone(), 
            customer.getIsActive()
        );
    }
}
