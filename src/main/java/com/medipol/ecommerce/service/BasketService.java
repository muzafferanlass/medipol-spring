package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private Basket basket = new Basket();

    public void createBasket() {
        basket = new Basket();
    }

    public void printBasketDetail() {
        //TODO productName, quantity
    }

    public void addProduct(Product product, Integer quantity){
        //TODO
    }

    public void removeProduct(Product product){
        //TODO
        //sepetten ilgili ürünü silmeli
    }

    public void incrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar artirilmali
    }

    public void decrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar azaltilmali
        //0 ise sepetten cikartilmali
    }

    public Basket getBasket() {
        return basket;
    }

    public Integer getBasketPrice() {
        //TODO  sepet tutarini donmeli
        return 0;
    }

}
