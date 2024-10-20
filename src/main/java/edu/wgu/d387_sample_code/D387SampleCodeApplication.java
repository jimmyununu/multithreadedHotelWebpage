package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		displayWelcomeMessages();
	}

	public static void displayWelcomeMessages() {
		// English welcome
		Thread englishThread = new Thread(() -> {
			Locale enLocale = new Locale("en", "US");
			ResourceBundle bundle = ResourceBundle.getBundle("translation", enLocale);
			System.out.println("English: " + bundle.getString("message")); //just to ensure this thread is working
		});
		// French welcome
		Thread frenchThread = new Thread(() -> {
			Locale frLocale = new Locale("fr", "CA");
			ResourceBundle bundle = ResourceBundle.getBundle("translation", frLocale);
			System.out.println("French: " + bundle.getString("message")); //just to ensure this thread is working
		});
		//stats my welcome threads
		englishThread.start();
		frenchThread.start();
	}

}
