package com.colak.springcloudstreamdebezium.config.jackson;

import com.colak.springcloudstreamdebezium.model.debezium.OperationType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class OperationTypeDeserializer extends JsonDeserializer<OperationType> {

    @Override
    public OperationType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return OperationType.fromCode(jsonParser.getValueAsString());
    }
}