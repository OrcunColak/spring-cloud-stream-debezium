package com.colak.springcloudstreamdebezium.model.debezium;

import com.colak.springcloudstreamdebezium.config.jackson.MillisToLocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Source {
    @JsonProperty("ts_ms")
    @JsonDeserialize(using = MillisToLocalDateTimeDeserializer.class)
    private LocalDateTime transactionTime;

    private String db;
    private String schema;
    private String table;

    @JsonProperty("txId")
    private long transactionId;
}
