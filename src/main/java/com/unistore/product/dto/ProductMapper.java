package com.unistore.product.dto;

import java.util.List;
import com.unistore.product.Product;
import com.unistore.product.dto.request.ProductRequest;
import com.unistore.product.dto.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse productToProductResponse(Product product);
    ProductRequest productToProductRequest(Product product);
    Product productRequestToProduct(ProductRequest request);
    Product productResponseToProduct(ProductResponse response);
    List<ProductResponse> productsToProductResponses(List<Product> products);
}
