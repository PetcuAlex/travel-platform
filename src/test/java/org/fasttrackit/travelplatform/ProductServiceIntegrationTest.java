package org.fasttrackit.travelplatform;

import org.fasttrackit.travelplatform.persistence.Product;
import org.fasttrackit.travelplatform.service.ProductService;
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

    @Test
    public void testCreateProduct_whenValidRequest_thenReturnCreatedProduct(){
        SaveProductRequest request = new SaveProductRequest();
        request.setName("London City Break");
        request.setDescription("A good experience with your friends in an amazing city.");
        request.setPrice(250);
        request.setQuantity(100);

        Product product = productService.createProduct(request);

        assertThat(product,notNullValue());
        assertThat(product.getId(), notNullValue());
        assertThat(product.getId(),greaterThan(0L));
        assertThat(product.getName(), is(request.getName()));
        assertThat(product.getDescription(),is(request.getDescription()));
        assertThat(product.getPrice(),is(request.getPrice()));
        assertThat(product.getQuantity(),is(request.getQuantity()));
    }

}
