package com.unistore.product.dto;

import java.util.List;

import com.unistore.manufacturer.ManufacturerService;
import com.unistore.product.Product;
import com.unistore.product.dto.request.ProductRequest;
import com.unistore.product.dto.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ManufacturerService.class)
public interface ProductMapper {

    @Mapping(source = "manufacturer.id", target = "manufacturerId")
    ProductResponse productToProductResponse(Product product);

    ProductRequest productToProductRequest(Product product);

    @Mapping(source = "manufacturerId", target = "manufacturer")
    Product productRequestToProduct(ProductRequest request);

    Product productResponseToProduct(ProductResponse response);

    List<ProductResponse> productsToProductResponses(List<Product> products);
}
