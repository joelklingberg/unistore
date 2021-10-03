package com.unstore.order.enums;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PaymentMethodConverter implements AttributeConverter<PaymentMethod, String> {
 
    @Override
    public String convertToDatabaseColumn(PaymentMethod pm) {
        if (pm == null) {
            return null;
        }
        return pm.getMethod();
    }

    @Override
    public PaymentMethod convertToEntityAttribute(String pm) {
        if (pm == null) {
            return null;
        }

        return Stream.of(PaymentMethod.values())
          .filter(m -> m.getMethod().equals(pm))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}