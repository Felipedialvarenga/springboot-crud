package com.example.springboot.service;

import com.example.springboot.dto.ProductDTO;
import com.example.springboot.model.Product;
import com.example.springboot.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Product> createProduct(ProductDTO productDTO){
        var newProduct = new Product();
        BeanUtils.copyProperties(productDTO,newProduct);
        productRepository.save(newProduct);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts = productRepository.findAll();
        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }

    public ResponseEntity<Object> getOneProduct(UUID id){
        Optional<Product> chosenProduct = productRepository.findById(id);
        if(chosenProduct.isEmpty()){
            return new ResponseEntity<>("Product not found.",HttpStatus.OK);
        }
        return new ResponseEntity<>(chosenProduct,HttpStatus.OK);
    }

    public ResponseEntity<Object> updateProduct(UUID id, ProductDTO productDTO){
        Optional<Product> chosenProduct = productRepository.findById(id);
        if(chosenProduct.isEmpty()){
            return new ResponseEntity<>("Product not found.",HttpStatus.OK);
        }
        var foundProduct = chosenProduct.get();
        BeanUtils.copyProperties(productDTO, foundProduct);
        productRepository.save(foundProduct);
        return new ResponseEntity<>(foundProduct,HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteProduct(UUID id){
        Optional<Product> chosenProduct = productRepository.findById(id);
        if(chosenProduct.isEmpty()){
            return new ResponseEntity<>("Product not found.",HttpStatus.OK);
        }
        productRepository.deleteById(id);
        return new ResponseEntity<>("Product deleted successfully.",HttpStatus.OK);
    }

}
