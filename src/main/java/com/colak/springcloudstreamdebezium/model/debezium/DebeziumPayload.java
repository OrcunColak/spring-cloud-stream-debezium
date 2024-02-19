package com.colak.springcloudstreamdebezium.model.debezium;

import com.colak.springcloudstreamdebezium.config.jackson.OperationTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.util.Map;

@Getter
public class DebeziumPayload {
    private Source source;

    private Map<String, Object> before;

    private Map<String, Object> after;

    @JsonDeserialize(using = OperationTypeDeserializer.class)
    @JsonProperty("op")
    @JsonFormat
    private OperationType operationType;
}
