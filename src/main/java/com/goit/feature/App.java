package com.goit.feature;

import com.goit.feature.util.TimeZoneUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String timezone = "UTC+5";
        timezone = timezone.length() < 1 ?
                "UTC" : timezone.replace(" ", "+").toUpperCase();

        ZoneId zid = ZoneId.of(timezone);
        Clock clock = Clock.system(zid);
        String initTime = LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern(
                "yyyy-MM-dd hh:mm:ss "
        ));
        String dec = URLEncoder.encode("+", "utf8");
        System.out.println("dec = " + dec);

        System.out.println("ZoneId.of(timezone) = " + ZoneId.of(timezone));
        System.out.println("initTime = " + initTime + zid);
    }
}
