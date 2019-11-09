package org.fasttrackit.travelplatform.web;


import org.fasttrackit.travelplatform.service.CartService;
import org.fasttrackit.travelplatform.transfer.cart.AddProductToCartRequest;
import org.fasttrackit.travelplatform.transfer.cart.CartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping
    public ResponseEntity addProductToCart(@RequestBody @Valid AddProductToCartRequest request) {

        cartService.addProductToCart(request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCart(@PathVariable("id") long customerId) {

        CartResponse cart = cartService.getCart(customerId);

        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
