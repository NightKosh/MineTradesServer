package com.nightkosh.minetrades.model.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OwnerConverter implements AttributeConverter<String, String> {

    private static final Logger log = LoggerFactory.getLogger(OwnerConverter.class);

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            try {
                JSONObject obj = new JSONObject(dbData.replace("\\\"", "'"));
                return obj.getString("owner");
            } catch (JSONException e) {
                log.error(String.format("Can't parse json to player's uuid : %s", dbData));
            }
        }
        return dbData;
    }
}
