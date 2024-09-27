package com.sherwin.infrastructure.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sherwin.application.customer.create.CreateCustomerCommand;
import com.sherwin.application.customer.retrieve.get.getById.GetByCustomerIdCommand;
import com.sherwin.application.customer.retrieve.get.getByIdentity.GetByCustomerDocumentCommand;
import com.sherwin.application.customer.retrieve.list.FindAllCustomersOutput;
import com.sherwin.domain.customer.CustomerId;
import com.sherwin.infrastructure.api.CustomerApi;
import com.sherwin.infrastructure.configuration.useCases.CustomerUseCaseConfig;
import com.sherwin.infrastructure.customer.model.CreateClientRequest;
import com.sherwin.infrastructure.customer.model.CreateCustomerResponse;
import com.sherwin.infrastructure.customer.model.FindAllCustomersRequest;
import com.sherwin.infrastructure.customer.model.FindByCustomerDocumentRequest;
import com.sherwin.infrastructure.customer.model.FindByCustomerIdRequest;

@RestController
public class CustomerController implements CustomerApi {

    private final CustomerUseCaseConfig customerUseCaseConfig;

    public CustomerController(CustomerUseCaseConfig customerUseCaseConfig) {
        this.customerUseCaseConfig = customerUseCaseConfig;
    }

    @Override
    public ResponseEntity<?> createClient(CreateClientRequest data) {

        try {
            final CreateCustomerCommand createCommand = CreateCustomerCommand.createCustomer(
                data.socialReason(), 
                data.fantasyName(), 
                data.identity(), 
                data.phone(), 
                data.isActive()
            );
    
            final var executeCommand  = this.customerUseCaseConfig
                .createCustomerUseCase()
                .execute(createCommand);
            
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateCustomerResponse(executeCommand.id(), "Cliente cadastrado com sucesso"));
                
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar novo cliente: " + e.getMessage());
        }
       

    }

    @Override
    public ResponseEntity<?> findByCustomerId(String id) {
        try {
            final GetByCustomerIdCommand aCommand = new GetByCustomerIdCommand(CustomerId.from(id));
            final var executeCommand = this.customerUseCaseConfig.getBycustomerIdUseCase().execute(aCommand);
            final FindByCustomerIdRequest data = new FindByCustomerIdRequest(
                executeCommand.id(), 
                executeCommand.socialReason(),
                executeCommand.fantasyName(), 
                executeCommand.identity(), 
                executeCommand.phone(), 
                executeCommand.isActive()
            );

            return ResponseEntity.ok(data);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar cliente por ID: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> findByCustomerDocument(String document) {
        try {
            final GetByCustomerDocumentCommand aCommand = new GetByCustomerDocumentCommand(document);
            final var executeCommand = this.customerUseCaseConfig.getByCustomerIdetityUseCase().execute(aCommand);
            final FindByCustomerDocumentRequest data = new FindByCustomerDocumentRequest(
                executeCommand.id(), 
                executeCommand.socialReason(),
                executeCommand.fantasyName(), 
                executeCommand.identity(), 
                executeCommand.phone(), 
                executeCommand.isActive()
            );

            return ResponseEntity.ok(data);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar cliente por documento: " + e.getMessage());

        }
    }

    @Override
    public ResponseEntity<?> findAllCustomers() {
        try {
            final List<FindAllCustomersOutput> listCustomersUseCase = this.customerUseCaseConfig.findAllCustomersUseCase().execute();
            final List<FindAllCustomersRequest> getCustomer = new ArrayList<>();
    
            for (FindAllCustomersOutput output : listCustomersUseCase) {
                final var findResponse = new FindAllCustomersRequest(
                        output.id(),
                        output.socialReason(),
                        output.fantasyName(),
                        output.identity(),
                        output.phone(),
                        output.isActive()
                );
    
                getCustomer.add(findResponse);
            }
    
            return ResponseEntity.ok(getCustomer);
        } 
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar lista de clientes: " + e.getMessage());
        }
    }
}
    

