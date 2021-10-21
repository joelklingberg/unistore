package com.unistore.manufacturer.dto;

import java.util.List;
import com.unistore.manufacturer.Manufacturer;
import com.unistore.manufacturer.dto.request.ManufacturerRequest;
import com.unistore.manufacturer.dto.response.ManufacturerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    // ManufacturerRequest -> Manufacturer
    Manufacturer manufacturerToManufacturerRequest(ManufacturerRequest request);

    // Manufacturer -> ManufacturerRequest
    ManufacturerRequest manufacturerToManufacturerRequest(Manufacturer manufacturer);

    // Manufacturer -> ManufacturerResponse
    ManufacturerResponse manufacturerToManufacturerResponse(Manufacturer manufacturer);

    // Manufacturers -> ManufacturerResponses
    List<ManufacturerResponse> manufacturersToManufacturerResponses(List<Manufacturer> manufacturers);
}
