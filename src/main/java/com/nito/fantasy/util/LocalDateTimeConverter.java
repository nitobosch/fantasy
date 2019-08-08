package com.nito.fantasy.util;

import java.time.LocalDateTime;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {

    @Override
    public String convert(LocalDateTime localDateTime) {
        return localDateTime.toString();
    }

    @Override
    public LocalDateTime unconvert(String s) {
        return LocalDateTime.parse(s);
    }
}
