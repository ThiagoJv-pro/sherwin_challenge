package com.sherwin.infrastructure.configuration.useCases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sherwin.application.customer.create.CreateCustomerUseCase;
import com.sherwin.application.customer.create.DefaultCreateCustomerUseCase;
import com.sherwin.application.customer.retrieve.get.getById.DefaultGetByCustomerIdUseCase;
import com.sherwin.application.customer.retrieve.get.getById.GetByCustomerIdUseCase;
import com.sherwin.application.customer.retrieve.get.getByIdentity.DefaultGetByCustomerDocumentUseCase;
import com.sherwin.application.customer.retrieve.get.getByIdentity.GetByCustomerDocumentUseCase;
import com.sherwin.application.customer.retrieve.list.DefaultFindAllCustomersUseCase;
import com.sherwin.application.customer.retrieve.list.FindAllCustomersUseCase;
import com.sherwin.domain.customer.CustomerGateway;

@Configuration
public class CustomerUseCaseConfig {
    
    private final CustomerGateway customerGateway;

    public CustomerUseCaseConfig(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(){
        return new DefaultCreateCustomerUseCase(customerGateway);
    }
    @Bean
    public GetByCustomerIdUseCase getBycustomerIdUseCase() {
        return new DefaultGetByCustomerIdUseCase(customerGateway);
    }

    @Bean
    public GetByCustomerDocumentUseCase getByCustomerIdetityUseCase(){
        return new DefaultGetByCustomerDocumentUseCase(customerGateway);
    }

    @Bean 
    public FindAllCustomersUseCase findAllCustomersUseCase(){
        return new DefaultFindAllCustomersUseCase(customerGateway);
    }

}
