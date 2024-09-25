package com.sherwin.infrastructure.customer.model;

import java.util.Optional;


public record FindByCustomerIdRequest(
    String id,
    String socialReason,
    String fantasyName,
    Optional<?> identity,
    String phone,
    Boolean isActive
) {

}
