package com.sherwin.domain.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {
    
    @Test
    public void givenAValidParams_whenCallCreateClient_thenInstantiatedANewClient() {
        
        //given
        final var expectedSocialReason = "teste";
        final var expectedFantasyName = "Sherwin";
        final var expectedIdentity = "64590176000123";
        final var expectedPhone = "11111111111";
        final var expectedIsActive = true;

        //When
        final var expectedClient = Customer.createCustomer(
            expectedSocialReason, 
            expectedFantasyName, 
            expectedIdentity, 
            expectedPhone, 
            expectedIsActive
        );

        //Then
        Assertions.assertNotNull(expectedClient);
    }


}
