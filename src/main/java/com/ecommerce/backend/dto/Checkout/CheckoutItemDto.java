package com.ecommerce.backend.dto.Checkout;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutItemDto {
    private String productName;
    private int  quantity;
    private double price;
    private long productId;

    public CheckoutItemDto() {}

    public CheckoutItemDto(String productName, int quantity, double price, long productId) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }
}
