package com.unstore.product.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UnitConverter implements AttributeConverter<Unit, String>  {

    @Override
    public String convertToDatabaseColumn(Unit unit) {
        if (unit == null) {
            return null;
        }
        return unit.getUnit();
    }

    @Override
    public Unit convertToEntityAttribute(String unit) {
        if (unit == null) {
            return null;
        }

        return Stream.of(Unit.values())
          .filter(u -> u.getUnit().equals(u))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
    
}
