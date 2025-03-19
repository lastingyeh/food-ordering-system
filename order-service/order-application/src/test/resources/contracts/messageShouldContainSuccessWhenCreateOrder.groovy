package contracts

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.dto.create.OrderAddress
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return even when number input is even"
    request{
        method POST()
        url("/orders") {
            headers {
                contentType(applicationJson())
            }
            CreateOrderCommand createOrderCommand = new CreateOrderCommand(
                    UUID.randomUUID(),
                    UUID.randomUUID(),
                    BigDecimal.valueOf(9999.99),
                    Collections.emptyList(),
                    new OrderAddress("street", "postalCode", "city")
            )
            body(net.javacrumbs.jsonunit.core.internal.JsonUtils.convertToJson(createOrderCommand))
        }
    }
    response {
        body("Even")
        status 200
    }
}
