package com.food.ordering.system;

import com.food.ordering.system.customer.service.domain.ports.input.service.CustomerApplicationService;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class CustomerApplicationServiceTestConfig {

    @Bean
    public CustomerApplicationService customerApplicationService() {
        return Mockito.mock(CustomerApplicationService.class);
    }
}
