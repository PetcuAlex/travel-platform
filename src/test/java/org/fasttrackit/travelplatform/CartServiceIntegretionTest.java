package org.fasttrackit.travelplatform;


import org.fasttrackit.travelplatform.domain.Customer;
import org.fasttrackit.travelplatform.service.CartService;
import org.fasttrackit.travelplatform.steps.CustomerSteps;
import org.fasttrackit.travelplatform.transfer.cart.AddProductToCartRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceIntegretionTest {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerSteps customerSteps;

    @Test
    public void testAddToCart_whenNewCart_thenCreateCart() {
        Customer customer = customerSteps.createCustomer();

        AddProductToCartRequest request = new AddProductToCartRequest();
        request.setCustomerId(customer.getId());

        request.setProductId(10L);

        cartService.addProductToCart(request);
    }
}
