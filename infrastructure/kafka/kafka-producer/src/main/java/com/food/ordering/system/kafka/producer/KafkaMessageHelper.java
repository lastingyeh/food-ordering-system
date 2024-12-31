package com.food.ordering.system.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaMessageHelper {
    public <T> ProducerListener<String, T> getKafkaCallback(String responseTopicName, T avroModel, String orderId, String avroModelName) {
        return new ProducerListener<>() {
            @Override
            public void onError(ProducerRecord<String, T> producerRecord, RecordMetadata recordMetadata, Exception exception) {
                log.error("Error while sending {} message {} to topic {}",
                        avroModelName, avroModel.toString(), responseTopicName, exception);
            }

            @Override
            public void onSuccess(org.apache.kafka.clients.producer.ProducerRecord<String, T> producerRecord, RecordMetadata metadata) {
                log.info("Received successful response from Kafka for order id: {}" +
                                " Topic: {} Partition: {} Offset: {} Timestamp: {}",
                        orderId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp());
            }
        };
    }
}