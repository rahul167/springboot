package com.sap.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.util.Properties;
import java.util.Arrays;

public class kafkaReader {
	
	public static void main (String args[]){
		// Create a consumer
		KafkaConsumer<String, String> consumer;
		// Configure the consumer
		Properties kafkaProps = new Properties();
		// Point it to the brokers
		kafkaProps.setProperty("bootstrap.servers", "localhost:9092");
		// Set the consumer group (all consumers must belong to a group).
		kafkaProps.setProperty("group.id", "user-tracking-consumer");
		// Set how to serialize key/value pairs
		kafkaProps.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		kafkaProps.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		// kafkaProps a group is first created, it has no offset stored to start reading from.
		// This tells it to start
		// with the earliest record in the stream.
		kafkaProps.setProperty("auto.offset.reset", "earliest");

		// specify the protocol for Domain Joined clusters
		// properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG,
		// "SASL_PLAINTEXT");

		consumer = new KafkaConsumer<>(kafkaProps);

		// Subscribe to the 'test' topic
		consumer.subscribe(Arrays.asList("user-tracking"));

		// Loop until ctrl + c
		int count = 0;
		while (true) {
			// Poll for records
			ConsumerRecords<String, String> records = consumer.poll(200);
			// Did we get any?
			if (records.count() == 0) {
				// timeout/nothing to read
			} else {
				// Yes, loop over records
				for (ConsumerRecord<String, String> record : records) {
					// Display record and count
					count += 1;
					System.out.println(count + ": " + record.value());
				}
			}
		}
	}
}
