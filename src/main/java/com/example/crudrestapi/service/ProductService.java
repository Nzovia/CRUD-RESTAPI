package com.example.crudrestapi.service;

import com.example.crudrestapi.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//service class stands at the mid of persistent layer and the data access layer
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
}
