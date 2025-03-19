package com.food.ordering.system;

import com.food.ordering.system.customer.service.domain.create.CreateCustomerCommand;
import com.food.ordering.system.customer.service.domain.create.CreateCustomerResponse;
import com.food.ordering.system.customer.service.domain.ports.input.service.CustomerApplicationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class CustomerApplicationServiceTests {

    CustomerApplicationService customerApplicationService = Mockito.mock(CustomerApplicationService.class);

    @BeforeAll
    public void init() {
        CreateCustomerResponse createCustomerResponse = new CreateCustomerResponse(
                UUID.randomUUID(), "Customer saved successfully!"
        );

        Mockito.when(customerApplicationService.createCustomer(Mockito.any())).thenReturn(createCustomerResponse);
    }

    @Test
    public void createUser() {
        // given

        // when
        CreateCustomerResponse response = customerApplicationService.createCustomer(
                CreateCustomerCommand.builder().build()
        );

        // then
        assert response.getMessage().contains("successfully");
    }
}
