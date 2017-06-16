package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping()//TODO
@RestController
public class MedipolBasketRestController {

    @Autowired public BasketService basketService;
    @Autowired public ProductService productService;

    //addToBasket

    @RequestMapping(path = "/addToBasket")
    public Basket addToBasket(@RequestParam int productId, @RequestParam int quantity) {

        Product product = productService.findBy(productId);
        basketService.addProduct(product,quantity);
        return basketService.getBasket();

    }

    //createBasket

    @RequestMapping(path = "/createBasket")
    public Basket createBasket(@RequestParam int productId, @RequestParam int quantity) {
        basketService.createBasket();
        return basketService.getBasket();

    }


    //getBasketDetail

    @RequestMapping(path = "/getBasketDetail")
    public void getBasketDetail(@RequestParam int productId, @RequestParam int quantity) {
      basketService.printBasketDetail();
    }


    //removeProduct

    @RequestMapping(path = "/removeProduct")
    public boolean getBasketDetail(@RequestParam int productId) {
        Product product = productService.findBy(productId);


            for(BasketItem Item: basketService.getBasket().getItems()){
                if (product != null){
                    if (Item.getProduct().getId().equals(productId)){

                    basketService.getBasket().getItems().remove(productId);
                    System.out.println("Information : " + "Product removed !");
                    return true;
                }} else if (product == null) {
                    System.out.println("Warning : " + "Product null !");
                    return false;
                }}
                return false;
    }


    //incrementQuantity

    @RequestMapping(path = "/incrementQuantity")
    public boolean incrementQuantity(@RequestParam int productId,@RequestParam int quantity) {
    Product product = productService.findBy(productId);

    if (product != null){
        basketService.incrementQuantity(product,quantity);
        System.out.println("Information : " + "Successful !");
        return true;

    } else if (product == null) {
        System.out.println("Warning : " + "Product null !");
        return false;
    }
        return false;
    }


    //decrementQuantity

    @RequestMapping(path = "/decrementQuantity")
    public boolean decrementQuantity(@RequestParam int productId,@RequestParam int quantity) {
        Product product = productService.findBy(productId);
        if (product != null){
            basketService.decrementQuantity(product,quantity);
            basketService.removeProduct(product);
            System.out.println("Information : " + " Successfully removed !");
            return true;

        } else if(product == null){
            System.out.println("Warning : " + "Product null !");
            return false;
        }
        return false;
    }


    //getBasketPrice

    @RequestMapping(path = "/getBasketPrice")
    public Integer getBasketPrice() {
        try {
            return basketService.getBasket().calculateBasketPrice();
        }catch (Exception x){
            System.out.println("Warning : " + x);
            return null;
        }
    }

}
