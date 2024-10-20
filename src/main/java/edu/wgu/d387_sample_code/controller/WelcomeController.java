package edu.wgu.d387_sample_code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/welcome-messages")
    public List<String> getWelcomeMessages() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> englishTask = () -> {
            Locale enLocale = new Locale("en", "US");
            ResourceBundle bundle = ResourceBundle.getBundle("translation", enLocale);
            return bundle.getString("message");
        };

        Callable<String> frenchTask = () -> {
            Locale frLocale = new Locale("fr", "CA");
            ResourceBundle bundle = ResourceBundle.getBundle("translation", frLocale);
            return bundle.getString("message");
        };

        Future<String> englishMessage = executor.submit(englishTask);
        Future<String> frenchMessage = executor.submit(frenchTask);

        List<String> messages = new ArrayList<>();
        messages.add(englishMessage.get());
        messages.add(frenchMessage.get());

        executor.shutdown();

        return messages;
    }
}



