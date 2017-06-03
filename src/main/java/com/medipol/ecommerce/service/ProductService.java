package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Product;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class ProductService {

    public List<Product> products = new ArrayList<Product>();

    public ProductService() {

        products.add(new Product(1, "nike air", 200));
        products.add(new Product(2, "adidas", 300));
    }

    public void add(Integer id, String name, Integer price ){
        //TODO

        products.add(new Product(id,name,price));

        for(Product alertx : products) {

            System.out.println("Id : "+ alertx.getId());
            System.out.println("Name : " + alertx.getName());
            System.out.println("Price : " + alertx.getPrice());
            System.out.println("\n");

        }
    }

    public void delete(Integer id) {
        //TODO

        Iterator<Product> del = products.iterator();
        while (del.hasNext()) {
            Product delete = del.next();
            if (delete.getId().equals(id)) {
                products.forEach(System.out::println);
                System.out.println();
                del.remove();
                products.forEach(System.out::println);
            }
        }
    }

    public void update(Integer id, String name, Integer price){
        //TODO


        for (int i = 0; i < products.size(); i++) {

            if (id == products.get(i).getId()) {

                if (products.get(i).getId().equals(id)){

                products.get(i).SelectName(name);
                products.get(i).SelectPrice(price);

                System.out.println("Update result : " + products.get(i).getId() + " - " + products.get(i).getName() + " - " + products.get(i).getPrice());

                }
            }
        }
    }

    public List<Product> list(){
        return products;
    }

    public Product findBy(int productId) {
        //TODO


        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {

                System.out.println("Found Result : " + products.get(i).getId() + " - " + products.get(i).getName() + " - " + products.get(i).getPrice());

            }
        }

        return null;
    }
}
