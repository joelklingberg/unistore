package com.unistore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import com.unistore.product.dto.ProductMapper;
import com.unistore.product.dto.request.ProductRequest;
import com.unistore.product.dto.response.ProductResponse;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper mapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }
    
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponse> response = mapper.productsToProductResponses(products);
        return response;
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ProductResponse response = mapper.productToProductResponse(product);
        return response;
    }

    @PostMapping()
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        Product product = mapper.productRequestToProduct(request);
        Product createdProduct = productService.createProduct(product);
        ProductResponse response = mapper.productToProductResponse(createdProduct);
        return response;
    }
    
    @PutMapping("/{id}")
    public ProductResponse updateProduct(
        @RequestBody ProductRequest request,
        @PathVariable Long id
    ) {
        Product product = mapper.productRequestToProduct(request);
        Product updatedProduct = productService.updateProduct(id, product);
        ProductResponse response = mapper.productToProductResponse(updatedProduct);
        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
