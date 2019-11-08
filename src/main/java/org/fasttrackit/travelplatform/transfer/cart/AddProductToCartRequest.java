package org.fasttrackit.travelplatform.transfer.cart;

import com.sun.istack.NotNull;

public class AddProductToCartRequest {

    @NotNull
    private Long customerId;
    @NotNull
    private Long productId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "AddProductToCartRequest{" +
                "customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}
