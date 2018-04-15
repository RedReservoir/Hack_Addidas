package com.prototype.adidas.adidas.RetroFiiit;

import java.util.List;

import com.prototype.adidas.adidas.RetroFiiit.controller.DatabaseController;
import com.prototype.adidas.adidas.http.Product;
import com.prototype.adidas.adidas.http.Size;
import com.prototype.adidas.adidas.http.User;

public class mainruben {
    public static void main(String[] args) {
        DatabaseController prueba = DatabaseController.getInstance();

        Product product = prueba.get_Product("1");
        System.out.println(product.toString());


    }
}
