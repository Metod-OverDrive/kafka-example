package com.example.kafkaserver.config;

import com.example.kafkaserver.config.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    private final KafkaProperties properties;

/*    @Bean
    public KafkaAdmin kafkaAdmin() {
        String servers = (String) properties
                .getProducerConfig()
                .get(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG);
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        return new KafkaAdmin(configs);
    }*/

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(properties.getProducerConfig());
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name("message-events-topic")
                .partitions(3)
                .replicas(3)
                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }
}
