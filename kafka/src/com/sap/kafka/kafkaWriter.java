package com.sap.kafka;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class kafkaWriter {

	public static void main(String args[]) throws IOException {
		Properties kafkaProps = new Properties();
		kafkaProps.setProperty("bootstrap.servers", "localhost:9092"); // comma seperated if multiple brokers.
		kafkaProps.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		kafkaProps.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);
		// So we can generate random sentences
		Random random = new Random();
		String[] sentences = new String[] { "the cow jumped over the moon", "an apple a day keeps the doctor away",
				"four score and seven years ago", "snow white and the seven dwarfs", "i am at two with nature" };

		String progressAnimation = "|/-\\";
		userData userDataObj = new userData();
		Properties userProp = userDataObj.getUserData();
		Set<String> keys = userProp.stringPropertyNames();
		// Produce a bunch of records
//		for (int i = 0; i < 100; i++) {
		int i = 0;
		for (String key : keys) {

			// Pick a sentence at random
			//String sentence = sentences[random.nextInt(sentences.length)];
			// Send the sentence to the test topic
			try {
				String value = userProp.getProperty(key);
				// producer.send(new ProducerRecord<String, String>("user-tracking",
				// sentence)).get();
				producer.send(new ProducerRecord<String, String>("user-tracking", key, value)).get();
				// producer.send(new ProducerRecord<String, String>("user-tracking",
				// sentence)).get();
			} catch (Exception ex) {
				System.out.print(ex.getMessage());
				throw new IOException(ex.toString());
			}
			String progressBar = "\r" + progressAnimation.charAt(i % progressAnimation.length()) + " " + i;
			System.out.write(progressBar.getBytes());
			i++;

		}
	}

}
