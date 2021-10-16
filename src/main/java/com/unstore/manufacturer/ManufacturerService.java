package com.unistore.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    
    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer getManufacturerById(Long id) {
        try {
            return manufacturerRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteManufacturer(Long id) {
        manufacturerRepository.deleteById(id);
    }

    public Manufacturer updateManufacturer(Long id, Manufacturer newManufacturer) {
        Manufacturer oldManufacturer = manufacturerRepository.findById(id).get();

        if(oldManufacturer != null) {
            newManufacturer.setId(id);
            return manufacturerRepository.save(newManufacturer);
        }

        return null;
    }
}
