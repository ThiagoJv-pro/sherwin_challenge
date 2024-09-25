package com.sherwin.domain.customer;

import java.util.Optional;

import com.sherwin.domain.AggregateRoot;

public class Customer extends AggregateRoot<CustomerId>{

    private final String socialReason;
    private final String fantasyName;
    private final Optional<Identity> identity;
    private final String phone;
    private final Boolean isActive;

    public Customer(
            CustomerId id,
            String socialReason,
            String fantasyName, 
            Optional<Identity> identity, 
            String phone, 
            Boolean isActive
        ) {
        super(id);
        this.identity = identity;
        this.fantasyName = fantasyName;
        this.isActive = isActive;
        this.phone = phone;
        this.socialReason = socialReason;
    }

    public static Customer createCustomer(
        String socialReason,
        String fantasyName,
        String identity,
        String phone,
        Boolean isActive
    ) {
        return new Customer(
            CustomerId.unique(),
            socialReason, 
            fantasyName, 
            Identity.createIdentity(identity), 
            phone, 
            isActive
        );
    }

    public static Customer with(
        CustomerId id,
        String socialReason,
        String fantasyName,
        Optional<Identity> identity,
        String phone,
        Boolean isActive
        ) {
        return new Customer(
            id, 
            socialReason,
            fantasyName,
            identity,
            phone,
            isActive
        );
    }

    public String getSocialReason() {
        return socialReason;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public Optional<Identity> getIdentity() {
        return identity;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

}
