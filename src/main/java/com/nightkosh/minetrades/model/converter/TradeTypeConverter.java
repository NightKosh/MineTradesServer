package com.nightkosh.minetrades.model.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;

/**
 * Convert data base integer column value to boolean value
 * sell - 0 - true
 * buy - 1 - false
 */
public class TradeTypeConverter implements AttributeConverter<Boolean, Integer> {

    private static final Logger log = LoggerFactory.getLogger(TradeTypeConverter.class);

    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        return attribute ? 0 : 1;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer dbData) {
        return dbData == 0;
    }
}
