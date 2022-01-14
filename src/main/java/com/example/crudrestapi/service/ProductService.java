package com.example.crudrestapi.service;

import com.example.crudrestapi.Repository.ProductRepository;
import com.example.crudrestapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//service class stands at the mid of persistent layer and the data access layer
public class ProductService {
    @Autowired //injecting product repository instance here
    private ProductRepository productRepo;

    //first method to list all the products
    public List<Product> displayAll(){
        return productRepo.findAll();
    }

    //product saving method
    public void save(Product productData){
        productRepo.save(productData);
    }

    //getting a particular product using its ID
    public  Product getProduct(Long id){
        //delegate a call to the repo
        return productRepo.findById(id).get();
    }

    //delete specific product by its own id
    public void delete(Long id){
        productRepo.deleteById(id);
    }
}
