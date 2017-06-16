package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.Iterator;



@Service
public class BasketService {

    private Basket basket = new Basket();

    public void createBasket() {
        basket = new Basket();
    }

    public void printBasketDetail() {
        //TODO

        for (BasketItem Item:basket.getItems()){
            System.out.println("Product Id: " + Item.getProduct().getId() + " -" + " Product Name: " + Item.getProduct().getName() + " -" + " Quantity: " + Item.getQuantity());
        }
    }

    public void addProduct(Product product ,Integer quantity){
        //TODO
        // sepete ürün eklemeli
        basket.addItem(new BasketItem(product,quantity));

    }

    public void removeProduct(Product product){
        //TODO
        //sepetten ilgili ürünü silmeli

        for (int i = 0; i < basket.getItems().size(); i++) {
            if ((basket.getItems().get(i).getProduct().equals(product))){
                basket.getItems().remove(basket.getItems().get(i));
                System.out.println("Information : " + "Product removed !");
            }
        }}

    public void incrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar artirilmali

        for (BasketItem Item:basket.getItems()){
            if (Item.getProduct().equals(product)){
                Item.Quantity(Item.getQuantity() + quantity);
            }

        }

    }

    public void decrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar azaltilmali
        //0 ise sepetten cikartilmali


            for (BasketItem Item:basket.getItems()) {
                if (Item.getProduct().equals(product)) {
                    if (Item.getQuantity() >= 0) {
                        Item.Quantity(Item.getQuantity() - quantity);
                    }

                    return;
    }}}


    public Basket getBasket() {
        return basket;
    }



    public Integer getBasketPrice() {
        //TODO  sepet tutarini donmeli

           return basket.calculateBasketPrice();
    }


}
