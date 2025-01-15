package com.example.kafkaclient.config;

import com.example.kafkaclient.config.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


@Configuration
@RequiredArgsConstructor
public class KafkaConfig {
    private final KafkaProperties properties;

    @Bean
    public ConsumerFactory<String, Object> producerFactory() {
        return new DefaultKafkaConsumerFactory<>(properties.getConfig());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory(
            ConsumerFactory<String, Object> consumerFactory) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

}
