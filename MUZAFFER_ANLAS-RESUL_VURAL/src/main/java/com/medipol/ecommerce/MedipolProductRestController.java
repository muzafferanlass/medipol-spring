package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping()//TODO
@RestController
public class MedipolProductRestController {


    @Autowired
    public ProductService productService = new ProductService();

    @Autowired
    public BasketService basketService = new BasketService();


    //add

    @RequestMapping(path = "/addProduct")
    public Product addProduct(@RequestParam int id, @RequestParam String name, @RequestParam int price) {

        try {
            Product product =  productService.add(id,name,price);
            System.out.println("Information : " + " Successfully added !");
            return product;
        } catch (Exception x){
            System.out.println("Warning : " + "Unsuccessful added !");
            return null;
        }

    }

    //delete

    @RequestMapping(path = "/deleteProduct")
    public boolean deleteProduct(@RequestParam int id,@RequestParam String name) {
        Product product = productService.findBy(id);
        if (product != null){
            productService.delete(id);
            System.out.println("Information : " + " Successfully removed !");
            return true;
        }else if (product == null){
            System.out.println("Warning : " + "Product null !");
            return false;
        } else {
            return false;
        }
    }

    //update

    @RequestMapping(path = "/updateProduct")
    public Product updateProduct(@RequestParam int id, @RequestParam String name, @RequestParam int price) {
        Product product = productService.findBy(id);
        if (product!=null){
            productService.products.get(id).SelectName(name);
            productService.products.get(id).SelectPrice(price);
            System.out.println("Information : " + " Successfully updated !");
            return product;
        }
        else if (product == null){
        System.out.println("Warning : " + "Product null !");
            return null;
        } else {
            return null;
        }
    }

    //list

    @RequestMapping(path = "/listProduct")
    public List<Product> listProduct() {
        return productService.products;
    }

    //findById

    @RequestMapping(path = "/findProduct")
    public Product findProduct(@RequestParam int id) {
        Product product = productService.findBy(id);
        if(product != null) {
            return product;
        } else {
            return null;
        }
    }

}
