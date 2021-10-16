package com.unistore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        try {
            return productRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product newProduct) {
        Product oldProduct = productRepository.findById(id).get();

        if(oldProduct != null) {
            newProduct.setId(id);
            return productRepository.save(newProduct);
        }

        return null;
    }
}
