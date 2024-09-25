package com.sherwin.infrastructure.customer;

import java.util.Optional;

import com.sherwin.domain.customer.Customer;
import com.sherwin.domain.customer.CustomerId;
import com.sherwin.domain.customer.Identity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers")
@Entity
public class CustomerJpaEntity {
    @Id
    @Column(name="id", nullable = false)
    private String id;
    private String socialReason;
    private String fantasyName;
    private String identity;
    private String identityType;
    private String phone;
    private Boolean isActive;

    public CustomerJpaEntity(
        String id, 
        String socialReason, 
        String fantasyName, 
        String identity,
        String identityType,
        String phone, 
        Boolean isActive
    ) {
        this.id = id;
        this.socialReason = socialReason;
        this.fantasyName = fantasyName;
        this.identity = identity;
        this.identityType = identityType;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Optional<Identity> getIdentityValid(String identity){
            return Identity.createIdentity(identity);
    }

    public static Customer toAggregate(CustomerJpaEntity customer) {
        return Customer.with(
            CustomerId.from(customer.getId()),
            customer.getSocialReason(),
            customer.getFantasyName(),
            customer.getIdentityValid(customer.getIdentity()),
            customer.getPhone(),
            customer.getIsActive()
        );
    }


}
