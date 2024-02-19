package com.colak.springcloudstreamdebezium.consumer;

import com.colak.springcloudstreamdebezium.model.debezium.DebeziumMessage;
import com.colak.springcloudstreamdebezium.model.debezium.DebeziumPayload;
import com.colak.springcloudstreamdebezium.model.debezium.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

@Slf4j
@Component
public class DebeziumMessageConsumer implements Consumer<DebeziumMessage> {

    @Override
    public void accept(DebeziumMessage eventDto) {
        try {
            DebeziumPayload payload = eventDto.getPayload();
            Source source = payload.getSource();
            log.info("tableName:{} , operation:{}, time:{}, value:{}",
                    source.getTable(),
                    payload.getOperationType().name(),
                    source.getTransactionTime(),
                    Optional.ofNullable(payload.getAfter()).map(Object::toString).orElse(null)
            );

        } catch (Exception e) {
            log.error("Failed to processing consumed message {}", eventDto, e);
        }
    }
}
