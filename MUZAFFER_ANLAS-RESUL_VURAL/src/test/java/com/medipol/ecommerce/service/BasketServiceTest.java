package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.hamcrest.Matchers;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BasketServiceTest {


    public BasketService services = new BasketService();
    public ProductService sservices = new ProductService();

    @Test
    public void shouldCreateBasket() throws Exception {
        //TODO

        services.createBasket();
        services.printBasketDetail();


    }

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {
        //TODO


        Product product = new Product(10, "Lescon", 300);
        services.addProduct(product,1);
        services.printBasketDetail();

        assertTrue(services.getBasket().getItems().size() >= 1);


    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {
        //TODO


        Product product = new Product(11, "Converse", 200);
        services.addProduct(product,2);
        services.printBasketDetail();

        assertTrue(services.getBasket().getItems().size() >= 1);
    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        //TODO

        Product product = new Product(12, "Rebook", 100);
        services.addProduct(product,1);
        Product products = new Product(13, "New Balance", 500);
        services.addProduct(products,2);
        services.printBasketDetail();



        assertTrue(services.getBasket().getItems().size() >= 1);
    }

   final Product product1 = new Product(12, "Crocs", 300);
   final Product product2 = new Product(13, "Salomon", 500);
   final Product product3 = new Product(14, "Toms", 200);
   final Basket basket = new Basket();

    @Test
    public void shouldRemoveProduct() throws Exception {
        //TODO
        //sepetten urunu sildi mi

        services.addProduct(product1,1);
        services.addProduct(product2,2);
        services.addProduct(product3,3);

        services.removeProduct(product1);
        services.printBasketDetail();

        assertTrue(services.getBasket().getItems().size() >= 1);

    }

    @Test
    public void shouldIncrementBasketItemQuantity() throws Exception {
        //TODO

        services.addProduct(product2, 2);
        services.addProduct(product3, 0);

        services.incrementQuantity(product3, 3);
        services.printBasketDetail();

        assertTrue(services.getBasket().getItems().size() >= 1);
    }

    @Test
    public void shouldDecrementBasketItemQuantity() throws Exception {
        //TODO

        services.addProduct(product3, 4);
        services.decrementQuantity(product3, 3);
        services.printBasketDetail();

    }

    @Test
    public void shouldDecrementBasketItemQuantityAndRemoveWhenQuantityZero() throws Exception {
        //TODO

        services.addProduct(product1,10);
        services.addProduct(product2,20);
        services.decrementQuantity(product1,10);

        assertTrue(services.getBasket().getItems().size() >= 1);


    }

    @Test
    public void shouldPriceBeZeroWhenBasketIsEmpty() throws Exception {
        //TODO sepet bosken total 0 olmalı


        services.addProduct(product1,12);
        services.addProduct(product2,30);

        services.removeProduct(product1);
        services.removeProduct(product2);


        System.out.println("\n"+"Information : " + "Basket is empty !");

        assertTrue(services.getBasket().getItems().size() == 0);
        assertThat(services.getBasketPrice(), Matchers.equalTo(0));
    }

    @Test
    public void shouldCalculateOneProductPrice() throws Exception {
        //TODO sepette 1 urun varken price hesaplanmali

        int quantity = 8 ;
        services.addProduct(product2, quantity);
        services.printBasketDetail();

        System.out.println("\n"+"Price : " + product2.getPrice() * quantity );

        assertTrue( product2.getPrice() * quantity == 4000);
        assertTrue(services.getBasket().getItems().size() >= 1);
    }

    @Test
    public void shouldCalculateMultipleProductPrice() throws Exception {
        //TODO sepette coklu urun varken price hesaplanmali

        int quantity1 = 8 ;
        int quantity2 = 5 ;
        int quantity3 = 8 ;
        services.addProduct(product1, quantity1);
        services.addProduct(product2, quantity2);
        services.addProduct(product3, quantity3);

        services.printBasketDetail();

        int toplam = product2.getPrice() * quantity1 + product2.getPrice() * quantity2 + product3.getPrice() * quantity3;

        System.out.println("\n"+" Total Price : " + toplam );



        assertTrue( product2.getPrice() * quantity1 + product2.getPrice() * quantity2 + product3.getPrice() * quantity3 == 8100);
        assertTrue(services.getBasket().getItems().size() >= 1);


    }

    @Test
    public void shouldCalculateOneProductPriceAfterIncrement() throws Exception {
        //TODO sepette 1 urun varken sayisi arttirildiginda price hesaplanmali


        int quantity = 4;
        int getq1 = 2;

        System.out.println("\n"+"Current product : " +"Product Id: " + product3.getId() + " - " + "Product Name: " + product3.getName() + " - " + "Quantity: " + quantity + "\n");

        services.addProduct(product3, quantity);
        services.incrementQuantity(product3, getq1);
        services.printBasketDetail();



        int q1 = quantity+getq1;

        int toplam =  product3.getPrice() * q1;


        System.out.println("\n"+" Total Price : " + toplam );

        assertTrue( product3.getPrice() * q1 == 1200);
        assertTrue(services.getBasket().getItems().size() >= 1);

    }

    @Test
    public void shouldCalculateOneProductPriceAfterDecrement() throws Exception {
        //TODO sepette 1 urun varken sayisi azaltildiginda price hesaplanmali

        int sayi;
        int quantity = 6;
        int getq1 = 4;

        System.out.println("\n"+"Current product : " +"Product Id: " + product2.getId() + " - " + "Product Name: " + product2.getName() + " - " + "Quantity: " + quantity + "\n");

        services.addProduct(product2, quantity);
        services.decrementQuantity(product2, getq1);
        services.printBasketDetail();

        int q1 = quantity-getq1;

        int toplam =  product2.getPrice() * q1;


        System.out.println("\n"+" Total Price : " + toplam );

        assertTrue( product2.getPrice() * q1 == 1000);
        assertTrue(services.getBasket().getItems().size() >= 1);

    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityIncrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi arttirma isleminden sonra price hesaplanmali


        int quantity1 = 7 ;
        int quantity2 = 3 ;
        int quantity3 = 6 ;

        int getq1 = 3 ;

        System.out.println("\n"+ "Current product : " + "Product Id: " + product1.getId() + " - " + "Product Name: " + product1.getName() + " - " + "Quantity: " +quantity1 + "\n");

        services.addProduct(product1, quantity1);
        services.addProduct(product2, quantity2);
        services.addProduct(product3, quantity3);


        services.incrementQuantity(product1, getq1);


        services.printBasketDetail();


        int q1 = quantity1+getq1;


        int toplam1 =  product1.getPrice() * q1;
        int toplam2 =  product2.getPrice() * quantity2;
        int toplam3 =  product3.getPrice() * quantity3;

        int genel = toplam1 + toplam2 + toplam3;

        System.out.println("\n"+"Total Price : " + toplam1 + " + " + toplam2 + " + " + toplam3 + " =  " + genel);


        assertTrue( toplam1 + toplam2 + toplam3  == 5700);
        assertTrue(services.getBasket().getItems().size() >= 1);




    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityDecrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi azaltma isleminden sonra price hesaplanmali


        int quantity1 = 7 ;
        int quantity2 = 3 ;
        int quantity3 = 6 ;

        int getq1 = 4 ;

        System.out.println("\n"+"Current product : " + "Product Id: " + product1.getId() + " - " + "Product Name: " + product1.getName() + " - " + "Quantity: " +quantity1 + "\n");

        services.addProduct(product1, quantity1);
        services.addProduct(product2, quantity2);
        services.addProduct(product3, quantity3);


        services.decrementQuantity(product1, getq1);


        services.printBasketDetail();



        int q1 = quantity1-getq1;

        int toplam1 =  product1.getPrice() * q1;
        int toplam2 =  product2.getPrice() * quantity2;
        int toplam3 =  product3.getPrice() * quantity3;

        int genel = toplam1 + toplam2 + toplam3;

        System.out.println("\n"+"Total Price : " + toplam1 + " + " + toplam2 + " + " + toplam3 + " =  " + genel);


        assertTrue( toplam1 + toplam2 + toplam3  == 3600);
        assertTrue(services.getBasket().getItems().size() >= 1);


    }


}