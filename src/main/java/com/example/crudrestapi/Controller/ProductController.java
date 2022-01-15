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
    //restful webservices to allow users to add an new object onto the database, we use http POST request
    @PostMapping("/productsList")
    public void add(@RequestBody Product product){
        productService.save(product);
    }

    //RestApi to update the information that we have in the database already
    @PutMapping("/productsList/{id}")
    public ResponseEntity<?> updateData(@RequestBody Product product, @PathVariable Long id){
        /*@RequestBody annotation tells spring to serialize(convert the representation of product into
         java object*/
        try {
            //Before  saving the new data lets check of the data exists, based on the product Id
            Product existsProduct = productService.getProduct(id);
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
