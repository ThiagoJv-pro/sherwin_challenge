package com.sherwin.infrastructure.customer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sherwin.infrastructure.customer.CustomerJpaEntity;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerJpaEntity, String> {
    
    @Query("SELECT c FROM CustomerJpaEntity c WHERE c.identity = :identity")
    public CustomerJpaEntity findByDocument(@Param("identity") String identity);
}
