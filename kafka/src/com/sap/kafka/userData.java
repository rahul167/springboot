package com.sap.kafka;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

//import kafka.coordinator.AbstractCoordinatorConcurrencyTest.RandomOperationSequence;

public class userData {
	Properties userProps = new Properties();

	userData() {

		// rand.nex
		// key - email id
		// id - brand, color, date, category
		userProps.put("Rah@gmail.com", "{t-shirt,black," + currentTime() + "}");
		addDelay();
		userProps.put("Rahul@yahoo.com", "{watch,digital," + currentTime() + "}");
		addDelay();
		userProps.put("uppi@msn.com", "{t-shirt,causal," + currentTime() + "}");
		addDelay();
		userProps.put("sable@gmail.com", "{pen,red," + currentTime() + "}");
		addDelay();
		userProps.put("yash@gmail.com", "{tv,flat," + currentTime() + "}");
		userProps.put("deva@sap.com", "{laptop,macbook," + currentTime() + "}");
		addDelay();
		userProps.put("anushka@oracle.com", "{mobile,android," + currentTime() + "}");
		userProps.put("tej@amazon.com", "{mobile,samsung," + currentTime() + "}");
		addDelay();
		userProps.put("ravi@gmail.com", "{earphone,black," + currentTime() + "}");
		addDelay();
		userProps.put("jay@yahoo.com", "{Iphone,12," + currentTime() + "}");
		addDelay();
		userProps.put("sebar@cruze.com", "{oven,samsung," + currentTime() + "}");
		addDelay();
		userProps.put("mike@gmail.com", "{medicine,cold," + currentTime() + "}");
		userProps.put("jeni@airtel.com", "{coat,causal," + currentTime() + "}");
		addDelay();
		userProps.put("surbhi@vodaphone.com", "{medicine,fever," + currentTime() + "}");
		addDelay();
		userProps.put("jinta@gmail.com", "{books,harry-potter," + currentTime() + "}");

	}

	public Properties getUserData() {

		return userProps;
	}

	public String currentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}

	public void addDelay() {
		int max = 2000, min = 800;
		int random_delay = (int) Math.floor(Math.random() * (max - min + 1) + min);
		try {
			Thread.sleep(random_delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		int min = 97;
		int max = 122;
		String name = "";
		String emailSuffix = "@gmail.com";
		int random_int = 97;
		for (int j = 0; j < 100; j++) {
			name = "";
			for (int i = 0; i < 3; i++) {
				// Generate random int value from 50 to 100
				// System.out.println("Random value in int from " + min + " to " + max + ":");
				random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
				name = name + Character.toString((char) random_int);
				// System.out.println(random_int);
				// System.out.println(Character.toString((char) random_int));
			}
			if (random_int > 107 && random_int < 112) {
				emailSuffix = "@msn.com";
			} else if (random_int > 113 && random_int < 116) {
				emailSuffix = "@yahoo.com";
			}
			System.out.println(name + emailSuffix);

		}
	}
}
