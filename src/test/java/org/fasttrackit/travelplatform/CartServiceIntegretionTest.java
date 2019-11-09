package org.fasttrackit.travelplatform;


import org.fasttrackit.travelplatform.domain.Cart;
import org.fasttrackit.travelplatform.domain.Customer;
import org.fasttrackit.travelplatform.domain.Product;
import org.fasttrackit.travelplatform.service.CartService;
import org.fasttrackit.travelplatform.steps.CustomerSteps;
import org.fasttrackit.travelplatform.steps.ProductSteps;
import org.fasttrackit.travelplatform.transfer.cart.AddProductToCartRequest;
import org.fasttrackit.travelplatform.transfer.cart.CartResponse;
import org.fasttrackit.travelplatform.transfer.product.ProductInCartResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceIntegretionTest {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerSteps customerSteps;

    @Autowired
    private ProductSteps productSteps;
    @Test
    public void testAddToCart_whenNewCart_thenCreateCart() {
        Customer customer = customerSteps.createCustomer();
        Product product = productSteps.createProduct();

        AddProductToCartRequest request = new AddProductToCartRequest();
        request.setCustomerId(customer.getId());
        request.setProductId(product.getId());

        cartService.addProductToCart(request);

        CartResponse cart = cartService.getCart(customer.getId());

        assertThat(cart, notNullValue());
        assertThat(cart.getId(),is(customer.getId()));
        assertThat(cart.getProducts(),notNullValue());
        assertThat(cart.getProducts(),hasSize(1));

        ProductInCartResponse productFromCart = cart.getProducts().iterator().next();

        assertThat(productFromCart,notNullValue());
        assertThat(productFromCart.getId(),is(request.getProductId()));
        assertThat(productFromCart.getName(),is(product.getName()));
        assertThat(productFromCart.getPrice(),is(product.getPrice()));
    }
}
