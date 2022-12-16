package com.goit.feature.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

public class TimeZoneUtil {
    public String parseTimeZone(HttpServletRequest request) {
        String standardTZ = "UTC";
        String result = (request.getCookies() == null) ? standardTZ :
                Stream.of(request.getCookies())
                        .filter(c -> "lastTimezone".equals(c.getName()))
                        .map(Cookie::getValue)
                        .findAny().orElseGet(() -> standardTZ);

        if (request.getParameterMap().containsKey("timezone")) {
            return (request.getParameter("timezone").replace(" ", "+").length() < 1) ?
                    result : request.getParameter("timezone").replace(" ", "+").toUpperCase();
        }
        return result;
    }
}
