package com.springbootprojectdress.Basics.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.List;

public class ProductImageConverter implements AttributeConverter<List<String>, String> {
    private static final ObjectMapper objMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null){
            return "[]";
        }
        try {
            return objMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null){
            return new ArrayList<>();
        }
        try {
            return objMapper.readValue(dbData, new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            return new ArrayList<>();
        }
    }
}
