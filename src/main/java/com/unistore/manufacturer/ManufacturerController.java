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

@RestController
@RequestMapping(value = "/manufacturers")
public class ManufacturerController {
    
    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }
    
    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    @GetMapping("/{id}")
    public Manufacturer getManufacturerById(@PathVariable Long id) {
        return manufacturerService.getManufacturerById(id);
    }

    @PostMapping()
    public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.createManufacturer(manufacturer);
    }
    
    @PutMapping("/{id}")
    public Manufacturer updateManufacturer(
        @RequestBody Manufacturer updatedManufacturer,
        @PathVariable Long id
    ) {
        return manufacturerService.updateManufacturer(id, updatedManufacturer);
    }

    @DeleteMapping("/{id}")
    public void deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
    }

}
