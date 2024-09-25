package com.sherwin.domain.customer;

import java.util.UUID;

import com.sherwin.domain.Identifier;

public class CustomerId extends Identifier {

    private final String id;

    public CustomerId(final String id){ 
        this.id = id;
    }

    public static CustomerId unique(){
        return new CustomerId(UUID.randomUUID().toString());
    }

    
    public static CustomerId from(final String id) {
        return new CustomerId(id);
    }

    @Override
    public String getValue() {
      return id;
    }
    
    
}
