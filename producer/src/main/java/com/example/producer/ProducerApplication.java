package com.example.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerApplication {
    public static void main(String[] args) {
        // Kafka Topic
        String topic = "simple-topic";

        // Kafka Producer Configuration
        Properties properties = new Properties();
        // bootstrap.servers, key.serializer, value.serializer
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Kafka Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Producer Record
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "Hello, Kafka!");

        // Kafka Producer Message Send
        producer.send(record);

        // Kafka Producer Close
        producer.flush();
        producer.close();
    }
}
