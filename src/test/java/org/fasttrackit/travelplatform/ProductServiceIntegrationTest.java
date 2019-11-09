package org.fasttrackit.travelplatform;

import org.fasttrackit.travelplatform.exception.ResourceNotFoundException;
import org.fasttrackit.travelplatform.domain.Product;
import org.fasttrackit.travelplatform.service.ProductService;
import org.fasttrackit.travelplatform.steps.ProductSteps;
import org.fasttrackit.travelplatform.transfer.product.SaveProductRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSteps productSteps;

    @Test
    public void testCreateProduct_whenValidRequest_thenReturnCreatedProduct() {

       productSteps.createProduct();
    }


    @Test
    public void testGetProduct_whenExistingEntity_thanReturnProduct() {
        Product createdProduct = productSteps.createProduct();

        Product retrievedProduct = productService.getProduct(createdProduct.getId());

        assertThat(retrievedProduct, notNullValue());
        assertThat(retrievedProduct.getId(), is(createdProduct.getId()));
        assertThat(retrievedProduct.getQuantity(), is(createdProduct.getQuantity()));
        assertThat(retrievedProduct.getPrice(), is(createdProduct.getPrice()));
        assertThat(retrievedProduct.getName(), is(createdProduct.getName()));
        assertThat(retrievedProduct.getDescription(), is(createdProduct.getDescription()));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void restGetProduct_whenNonExistingEntity_thanThrowNotFoundException() {
        productService.getProduct(99999);

    }

    @Test
    public void testUpdateProduct_whenValidRequest_thanReturnUpdatedProduct() {
        Product createdProduct = productSteps.createProduct();

        SaveProductRequest request = new SaveProductRequest();
        request.setName(createdProduct.getName() + " Updated");
        request.setPrice(createdProduct.getPrice() + 10);
        request.setQuantity(createdProduct.getQuantity() + 10);

        Product updatedProduct = productService.updateProduct(createdProduct.getId(), request);

        assertThat(updatedProduct, notNullValue());
        assertThat(updatedProduct.getId(), is(createdProduct.getId()));
        assertThat(updatedProduct.getDescription(), is(request.getDescription()));
        assertThat(updatedProduct.getName(), is(request.getName()));
        assertThat(updatedProduct.getPrice(), is(request.getPrice()));
        assertThat(updatedProduct.getQuantity(), is(request.getQuantity()));
    }


}
