package com.medipol.ecommerce.model;

public class BasketItem {

    private int quantity;
    private Product product;

    public BasketItem(Product product , int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer price() {
        //TODO
        return quantity * product.getPrice();
    }

    public void Quantity(int quantity) {
        this.quantity = quantity;
    }
}
