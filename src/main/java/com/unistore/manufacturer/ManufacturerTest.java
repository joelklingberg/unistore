package com.unistore.manufacturer;

import com.unistore.manufacturer.dto.ManufacturerMapper;
import com.unistore.manufacturer.dto.request.ManufacturerRequest;
import com.unistore.manufacturer.dto.response.ManufacturerResponse;
import com.unistore.test.TestEntityStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import static com.unistore.core.configuration.TestConfig.TEST_PROPERTY_SOURCE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = TEST_PROPERTY_SOURCE)
public class ManufacturerTest {

    @Autowired
    private ManufacturerController controller;

    @Autowired
    private ManufacturerMapper mapper;

    @Autowired
    private TestEntityStore testEntityStore;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    private Manufacturer getTestManufacturer() {
        return testEntityStore.getTestManufacturer();
    }

    @Test
    public void createManufacturer() {
        Manufacturer manufacturer = getTestManufacturer();
        ManufacturerRequest request = mapper.manufacturerToManufacturerRequest(manufacturer);
        ManufacturerResponse response = controller.createManufacturer(request);

        assertThat(response).isNotNull();

        // Assert that values have been stored correctly.
        assertThat(response.getAddress()).isEqualTo(manufacturer.getAddress());
        assertThat(response.getName()).isEqualTo(manufacturer.getName());
        assertThat(response.getCustomerContactEmail()).isEqualTo(manufacturer.getCustomerContactEmail());
        assertThat(response.getPhoneNo()).isEqualTo(manufacturer.getPhoneNo());

        // Retrieve manufacturer.
        assertThat(controller.getManufacturerById(response.getId())).isNotNull();
    }

    public void updateManufacturer() {
        // Create manufacturer.
        Manufacturer manufacturer = getTestManufacturer();
        ManufacturerRequest createRequest = mapper.manufacturerToManufacturerRequest(manufacturer);
        ManufacturerResponse createdResponse = controller.createManufacturer(createRequest);

        manufacturer.setName("New manufacturer name");
        manufacturer.setPhoneNo("1337");
        manufacturer.setAddress("New address");
        manufacturer.setCustomerContactEmail("newemail@email.com");

        ManufacturerRequest updateRequest = mapper.manufacturerToManufacturerRequest(manufacturer);

        ManufacturerResponse response = controller.updateManufacturer(updateRequest, createdResponse.getId());

        // Assert that values have been updated correctly.
        assertThat(response.getAddress()).isEqualTo(manufacturer.getAddress());
        assertThat(response.getName()).isEqualTo(manufacturer.getName());
        assertThat(response.getCustomerContactEmail()).isEqualTo(manufacturer.getCustomerContactEmail());
        assertThat(response.getPhoneNo()).isEqualTo(manufacturer.getPhoneNo());
    }

    @Test
    public void deleteManufacturer() throws Exception {
        Manufacturer manufacturer = getTestManufacturer();

        // Create manufacturer.
        ManufacturerRequest request = mapper.manufacturerToManufacturerRequest(manufacturer);
        ManufacturerResponse createdResponse = controller.createManufacturer(request);

        // Delete manufacturer.
        controller.deleteManufacturer(createdResponse.getId());

        // Attempt to retrieve deleted order.
        ManufacturerResponse deletedOrder = controller.getManufacturerById(createdResponse.getId());

        assertThat(deletedOrder).isNull();
    }

}
