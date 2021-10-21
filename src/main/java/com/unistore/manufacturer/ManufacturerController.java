package com.unistore.manufacturer;

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

import com.unistore.manufacturer.dto.ManufacturerMapper;
import com.unistore.manufacturer.dto.response.ManufacturerResponse;

@RestController
@RequestMapping(value = "/manufacturers")
public class ManufacturerController {
    
    private final ManufacturerService service;

    private final ManufacturerMapper mapper;

    @Autowired
    public ManufacturerController(
        ManufacturerService service,
        ManufacturerMapper mapper
    ) {
        this.service = service;
        this.mapper = mapper;
    }
    
    @GetMapping
    public List<ManufacturerResponse> getAllManufacturers() {
        List<Manufacturer> manufacturers = service.getAllManufacturers();
        List<ManufacturerResponse> response = mapper.manufacturersToManufacturerResponses(manufacturers);
        return response;
    }

    @GetMapping("/{id}")
    public ManufacturerResponse getManufacturerById(@PathVariable Long id) {
        Manufacturer manufacturer = service.getManufacturerById(id);
        ManufacturerResponse response = mapper.manufacturerToManufacturerResponse(manufacturer);
        return response;
    }

    @PostMapping()
    public ManufacturerResponse createManufacturer(@RequestBody Manufacturer manufacturer) {
        Manufacturer createdManufacturer = service.createManufacturer(manufacturer);
        ManufacturerResponse response = mapper.manufacturerToManufacturerResponse(createdManufacturer);
        return response;
    }
    
    @PutMapping("/{id}")
    public ManufacturerResponse updateManufacturer(
        @RequestBody Manufacturer updatedManufacturer,
        @PathVariable Long id
    ) {
        Manufacturer manufacturer = service.updateManufacturer(id, updatedManufacturer);
        ManufacturerResponse response = mapper.manufacturerToManufacturerResponse(manufacturer);
        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteManufacturer(@PathVariable Long id) {
        service.deleteManufacturer(id);
    }

}
