package org.fasttrackit.travelplatform.service;

import org.fasttrackit.travelplatform.persistance.ProductRepository;
import org.fasttrackit.travelplatform.persistence.Product;
import org.fasttrackit.travelplatform.transfer.product.SaveProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(SaveProductRequest request) {

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setImagePath(request.getImagePath());

       return productRepository.save(product);
    }
}
