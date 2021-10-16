package com.unistore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.unistore.product.enums.Unit;
import static com.unistore.core.configuration.TestConfig.TEST_PROPERTY_SOURCE;

@SpringBootTest
@TestPropertySource(locations = TEST_PROPERTY_SOURCE)
public class ProductTest {

	@Autowired
	private ProductController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	private Product getTestProduct() {
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
		Product createdProduct = controller.createProduct(product);

		// Assert that values are stored correctly.
		assertThat(createdProduct).isNotNull();
		assertThat(createdProduct.getDescription()).isEqualTo(product.getDescription());
		assertThat(createdProduct.getName()).isEqualTo(product.getName());
		assertThat(createdProduct.getPrice()).isEqualTo(product.getPrice());
		assertThat(createdProduct.getUnit()).isEqualTo(product.getUnit());

		// Retrieve product.
		Product storedProduct = controller.getProductById(createdProduct.getId());
		assertThat(storedProduct).isNotNull();
	}

	@Test
	public void updateProduct() throws Exception {
		Product product = getTestProduct();

		// Create product.
		Product createdProduct = controller.createProduct(product);

		// Update product.
		createdProduct.setDescription("New description");
		createdProduct.setName("New name");

		Product updatedProduct = controller.updateProduct(createdProduct, createdProduct.getId());

		assertThat(createdProduct.getName()).isEqualTo(updatedProduct.getName());
		assertThat(createdProduct.getDescription()).isEqualTo(updatedProduct.getDescription());
	}
	
	@Test
	public void deleteProduct() throws Exception {
		Product product = getTestProduct();

		// Create product.
		Product createdProduct = controller.createProduct(product);

		// Delete order.
		controller.deleteProduct(createdProduct.getId());

		// Attempt to retrieve deleted order.
		Product deletedProduct = controller.getProductById(createdProduct.getId());

		assertThat(deletedProduct).isNull();
	}

}