package edu.wgu.d387_sample_code.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TimeZoneConverter {


    public static Map<String, String> convertTimeZones(LocalDateTime presentationTime) {
        ZoneId utcZone = ZoneId.of("UTC");              // Universal Time
        ZoneId etZone = ZoneId.of("America/New_York");  // Eastern Time
        ZoneId mtZone = ZoneId.of("America/Denver");    // Mountain Time

        ZonedDateTime etTime = ZonedDateTime.of(presentationTime, etZone);
        ZonedDateTime mtTime = etTime.withZoneSameInstant(mtZone);
        ZonedDateTime utcTime = etTime.withZoneSameInstant(utcZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        Map<String, String> timeMap = new HashMap<>();
        timeMap.put("UTC", utcTime.format(formatter)); // Universal Time
        timeMap.put("ET", etTime.format(formatter));  // Eastern Time
        timeMap.put("MT", mtTime.format(formatter));  // Mountain Time


        //print to test (Not needed)
        System.out.println("Eastern Time (ET): " + etTime.format(formatter));
        System.out.println("Mountain Time (MT): " + mtTime.format(formatter));
        System.out.println("Coordinated Universal Time (UTC): " + utcTime.format(formatter));

        return timeMap;

    }
}

