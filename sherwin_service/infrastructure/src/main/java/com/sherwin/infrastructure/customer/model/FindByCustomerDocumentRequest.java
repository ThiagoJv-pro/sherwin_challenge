package com.sherwin.infrastructure.customer.model;

import java.util.Optional;

public record FindByCustomerDocumentRequest( 
    String id,
    String socialReason,
    String fantasyName,
    Optional<?> identity,
    String phone,
    Boolean isActive
) {

}
