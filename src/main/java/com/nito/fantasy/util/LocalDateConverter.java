package com.nito.fantasy.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    @Override
    public String convert(LocalDate localDate) {
        return localDate.toString();
    }

    @Override
    public LocalDate unconvert(String s) {
        return LocalDate.parse(s);
    }
}
