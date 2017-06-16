package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Product;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProductServiceTest {

    ProductService services = new ProductService();
    @Test

    public void shouldListInitialProducts() throws Exception {
        //TODO

        System.out.println("List : " + "\n" + services.list() +"\n");
        for(Product alertlist :services.products) {
            System.out.println("\n"+ "Product : " + alertlist + "\n");
            System.out.println("Id : "+alertlist.getId());
            System.out.println("Name : " + alertlist.getName());
            System.out.println("Price : " + alertlist.getPrice());
        }

        assertThat(services.products.size(), Matchers.greaterThan(0));

    }

    @Test
    public void shouldAddOneProduct() throws Exception {
        //TODO

        services.add(3,"supra",1000);

        for(Product alertx :services.products) {

            System.out.println("\n"+ "Product : " + alertx + "\n");
            System.out.println("Id : "+alertx.getId());
            System.out.println("Name : " + alertx.getName());
            System.out.println("Price : " + alertx.getPrice());

        }

        assertTrue(services.list().size() == 3);
        assertThat(services.products.size(), Matchers.greaterThan(0));

    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        //TODO

        services.add(3,"kinetix",500);
        services.add(4,"polaris",200);

        for(Product alertss : services.products) {



            System.out.println("Id : "+alertss.getId());
            System.out.println("Name : " + alertss.getName());
            System.out.println("Price : " + alertss.getPrice());
        }

        assertTrue(services.list().size() == 4);
        assertThat(services.products.size(), Matchers.greaterThan(0));

    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        //TODO


        int deleteid = 1;

            Iterator<Product> del = services.products.iterator();
            while (del.hasNext()) {
                Product delete = del.next();
                if (delete.getId().equals(deleteid)) {
                    services.products.forEach(System.out::println);
                    System.out.println();
                    del.remove();
                   services.products.forEach(System.out::println);
                }
            }

        assertThat(services.list().size() , Matchers.equalTo(1));
    }


    @Test
    public void shouldUpdateProductName() throws Exception {
        //TODO


        for(Product updater :services.products) {
            if(updater.getName().equals("adidas")) {
                System.out.println("\n" + "Result : " + "\n");
                System.out.println("Before : "+ updater.getName());
                updater.setName("supra");
                System.out.println("After : "+ updater.getName());
                System.out.println("\n");
                System.out.println("Id : "+ updater.getId());
                System.out.println("Name : " + updater.getName());
                System.out.println("Price : " + updater.getPrice());

            }

        }

        assertThat(services.products.size(), Matchers.greaterThan(0));
    }

    @Test
    public void shouldUpdateProductPrice() throws Exception {
        //TODO


        for(Product updater :services.products) {
            if(updater.getPrice().equals(200)) {
                System.out.println("\n" + "Result : " + "\n");
                System.out.println("Before : "+ updater.getPrice());
                updater.setPrice(500);
                System.out.println("After : "+ updater.getPrice());
                System.out.println("\n");
                System.out.println("Id : "+ updater.getId());
                System.out.println("Name : " + updater.getName());
                System.out.println("Price : " + updater.getPrice());

            }
        }

        assertThat(services.products.size(), Matchers.greaterThan(0));

    }

    @Test
    public void shouldUpdateProductNameAndPrice() throws Exception {
        //TODO

        for(Product alert :services.products) {
            System.out.println("Id : "+alert.getId());
            System.out.println("Name : " + alert.getName());
            System.out.println("Price : " + alert.getPrice());
            System.out.println("\n");
        }

        for(Product updater :services.products) {
            if(updater.getName().equals("adidas")) {
                System.out.println("\n" + "Result : " + "\n");
                System.out.println("Before : "+ "\n" + "Name : " +  updater.getName() + "\n" + "Price : " + updater.getPrice()+ "\n");
                updater.setName("supra");
                updater.setPrice(600);
                System.out.println("After : " + "\n" + "Name : "+ updater.getName() + "\n" + "Price : " + updater.getPrice()+"\n");
                System.out.println("\n");
                System.out.println("Id : "+ updater.getId());
                System.out.println("Name : " + updater.getName());
                System.out.println("Price : " + updater.getPrice());

            }
        }

        assertThat(services.products.size(), Matchers.greaterThan(0));



    }

}