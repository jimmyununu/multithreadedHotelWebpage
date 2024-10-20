package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.service.TimeZoneConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeController {

    @GetMapping("/live-presentation-times")
    public Map<String, String> getPresentationTimes() {
        // Set the time of the live presentation (you can adjust the time as needed)
        LocalDateTime presentationTime = LocalDateTime.of(2024, 10, 25, 15, 0); // Example: Oct 25, 2024, 15:00 (3:00 PM ET)

        // Call the time zone converter method to get times in ET, MT, and UTC
        return TimeZoneConverter.convertTimeZones(presentationTime);
    }
}

