package com.sherwin.infrastructure.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateClientRequest(
    @JsonProperty("socialReason") String socialReason,
    @JsonProperty("fantasyName") String fantasyName,
    @JsonProperty("document") String identity,
    @JsonProperty("phone") String phone,
    @JsonProperty("isActive") Boolean isActive
) {
    
}
