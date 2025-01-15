package com.example.kafkaserver.config.properties;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaProperties {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.producer.key-serializer}")
    private String keySerializer;

    @Value("${spring.kafka.producer.value-serializer}")
    private String valueSerializer;

    @Value("${spring.kafka.producer.retries}")
    private String retries;

    @Value("${spring.kafka.producer.acks}")
    private String acks;

    @Value("${spring.kafka.producer.properties.delivery.timeout.ms}")
    private String deliveryTimeout;

    @Value("${spring.kafka.producer.properties.linger.ms}")
    private String lingerMs;

    @Value("${spring.kafka.producer.properties.request.timeout.ms}")
    private String requestTimeout;

    @Value("${spring.kafka.producer.properties.enable.idempotence}")
    private String idempotence; /* Better check in consumer service, because when true, then acks == all */

    @Value("${spring.kafka.producer.properties.max.in.flight.requests.per.connection}")
    private String maxFlightRequests;

    public Map<String, Object> getProducerConfig() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, this.keySerializer);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, this.valueSerializer);
        config.put(ProducerConfig.RETRIES_CONFIG, this.retries);
        config.put(ProducerConfig.ACKS_CONFIG, this.acks);
        config.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, this.deliveryTimeout);
        config.put(ProducerConfig.LINGER_MS_CONFIG, this.lingerMs);
        config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, this.requestTimeout);
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, this.idempotence);
        config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, this.maxFlightRequests);

        return config;
    }

}
