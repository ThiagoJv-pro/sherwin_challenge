package com.sherwin.application.customer.retrieve.get.getByIdentity;

import java.util.Optional;

import com.sherwin.domain.customer.Customer;
import com.sherwin.domain.customer.Identity;

public record GetByCustomerDocumentOutput(
    String id,
    String socialReason,
    String fantasyName,
    Optional<Identity> identity,
    String phone,
    Boolean isActive

) {
    public static GetByCustomerDocumentOutput from(Customer client) {
        return new GetByCustomerDocumentOutput(
            client.getId().getValue(), 
            client.getSocialReason(), 
            client.getFantasyName(), 
            client.getIdentity(), 
            client.getPhone(), 
            client.getIsActive()
        );
    }
}
