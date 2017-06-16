package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BasketTest {

    public  Basket basket = new Basket();

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {

        final Product product = new Product(1, "nike air", 200);

        basket.addItem(new BasketItem(product, 1));

        assertTrue(basket.getItems().size() == 1);
        assertTrue(basket.getItems().get(0).getProduct().equals(product));

    }

    final Product product = new Product(1, "Adidas", 700);
    final Product product2 = new Product(2, "Puma ", 350);

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {

        //TODO

        basket.addItem(new BasketItem(product,4));

        assertTrue(basket.getItems().get(0).getQuantity() == 4 );
        assertTrue(basket.getItems().get(0).getProduct().equals(product));


    }

    @Test
    public void shouldAddTwoDifferentProduct() throws Exception {
        //TODO

        basket.addItem(new BasketItem(product,2));
        basket.addItem(new BasketItem(product2, 1));
        assertThat(basket.getItems().size(), Matchers.equalTo(2));

    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductOneQuantity() throws Exception {
        //TODO


        basket.addItem(new BasketItem(product, 1));
        assertTrue(basket.getItems().size() > 0);

    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductTwoQuantity() throws Exception {
        //TODO

        basket.addItem(new BasketItem(product2,2));
        assertTrue(basket.getItems().size() > 0);

    }

    @Test
    public void shouldCalculateBasketPriceWithMultipleProduct() throws Exception {
        //TODO
        basket.addItem(new BasketItem(product,1));
        basket.addItem(new BasketItem(product2,2));
        assertTrue(basket.getItems().size() > 0);
    }

    @Test
    public void shouldUpdateBasketItemQuantity() throws Exception {
        //TODO
        BasketItem Item = new BasketItem(product,5);
        basket.addItem(new BasketItem(product,2));
        basket.getItems().set(0,Item);
        assertTrue(basket.getItems().size() > 0);
    }

}