package com.example.crudrestapi.Controller;

import com.example.crudrestapi.model.Product;
import com.example.crudrestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController // tells springframework that this controller will handle restful web services
public class ProductController {
    @Autowired
    private ProductService productService;

    //implement methods for the restful web services api

    //list all products
    @GetMapping("/productsList")
    public List<Product> showAll(){
        return productService.displayAll();
    }

    //get a specific product from the database using id
    @GetMapping("/productsList/{id}")
    public ResponseEntity<Product> showSpecificProduct(@PathVariable Long id){
        //@PathVariable annotation is used to map the productId to the URL
        try{
            Product product = productService.getProduct(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

        }
    }
    //restful webservices to allow users add an new object onto the database
    @PostMapping("/productsList")
    public void add(@RequestBody Product product){
        productService.save(product);

    }
}
