package net.rabhi.inventoryservice.web;

import net.rabhi.inventoryservice.entities.Product;
import net.rabhi.inventoryservice.repositories.ProductRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin("*")
public class ProductRestController {
    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> products(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Product productById(@PathVariable String id){
        return productRepository.findById(id).get();
    }


    @GetMapping("/auth")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
