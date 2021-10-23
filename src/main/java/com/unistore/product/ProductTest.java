package com.unistore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.unistore.product.dto.ProductMapper;
import com.unistore.product.dto.request.ProductRequest;
import com.unistore.product.dto.response.ProductResponse;
import com.unistore.product.enums.Unit;
import static com.unistore.core.configuration.TestConfig.TEST_PROPERTY_SOURCE;

@SpringBootTest
@TestPropertySource(locations = TEST_PROPERTY_SOURCE)
public class ProductTest {

	@Autowired
	private ProductController controller;

	@Autowired
	private ProductMapper mapper;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	public Product getTestProduct() {
		Product product = new Product();

		product.setDescription("Test description");
		product.setName("Test product");
		product.setPrice(500);
		product.setUnit(Unit.EACH);

		return product;
	}

	@Test
	public void createProduct() throws Exception {
		Product product = getTestProduct();
		// Create product.
		ProductRequest createProductRequest = mapper.productToProductRequest(product);
		ProductResponse createdProductResponse = controller.createProduct(createProductRequest);
		Product createdProduct = mapper.productResponseToProduct(createdProductResponse);

		// Assert that values are stored correctly.
		assertThat(createdProduct).isNotNull();
		assertThat(createdProduct.getDescription()).isEqualTo(product.getDescription());
		assertThat(createdProduct.getName()).isEqualTo(product.getName());
		assertThat(createdProduct.getPrice()).isEqualTo(product.getPrice());
		assertThat(createdProduct.getUnit()).isEqualTo(product.getUnit());

		// Retrieve product.
		ProductResponse storedProductResponse = controller.getProductById(createdProduct.getId());
		Product storedProduct = mapper.productResponseToProduct(storedProductResponse);
		assertThat(storedProduct).isNotNull();
	}

	@Test
	public void updateProduct() throws Exception {
		Product product = getTestProduct();

		// Create product.
		ProductRequest createProductRequest = mapper.productToProductRequest(product);
		ProductResponse createdProductResponse = controller.createProduct(createProductRequest);
		Product createdProduct = mapper.productResponseToProduct(createdProductResponse);

		// Update product.
		createdProduct.setDescription("New description");
		createdProduct.setName("New name");

		ProductRequest updateProductRequest = mapper.productToProductRequest(createdProduct);

		ProductResponse updatedProductResponse = controller.updateProduct(updateProductRequest, createdProduct.getId());

		assertThat(createdProduct.getName()).isEqualTo(updatedProductResponse.getName());
		assertThat(createdProduct.getDescription()).isEqualTo(updatedProductResponse.getDescription());
	}
	
	@Test
	public void deleteProduct() throws Exception {
		Product testProduct = getTestProduct();

		// Create product.
		ProductRequest createProductRequest = mapper.productToProductRequest(testProduct);
		ProductResponse createdProductResponse = controller.createProduct(createProductRequest);
		Product createdProduct = mapper.productResponseToProduct(createdProductResponse);

		// Delete order.
		controller.deleteProduct(createdProduct.getId());

		// Attempt to retrieve deleted order.
		ProductResponse deletedProductResponse = controller.getProductById(createdProduct.getId());

		assertThat(deletedProductResponse).isNull();
	}

}