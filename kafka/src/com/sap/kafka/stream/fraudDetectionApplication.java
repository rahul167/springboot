package com.sap.kafka.stream;

import java.util.Properties;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

public class fraudDetectionApplication {
	public static void main(String args[]) {
		// from payment topic to validated payment topic
		// message key://String trsanactionId
		// message value://String userid, Integer numberOfItem, Float total amount
		Properties streamProperties = new Properties();
		String z = StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG;
		streamProperties.put(StreamsConfig.APPLICATION_ID_CONFIG, "fraud-detection-application");
		streamProperties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

		StreamsBuilder streambuilder = new StreamsBuilder();
		KStream<String, String> stream = streambuilder.stream(/*topic:*/ "zz");// topic name
		//stream.peek(fraudDetectionApplication::printOnEnter)
		//.filter("");
	}
	
	public static void printOnEnter(String transacitonid, String order) {
		
	}

}
