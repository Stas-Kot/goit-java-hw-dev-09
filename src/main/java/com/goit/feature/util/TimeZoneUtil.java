package com.goit.feature.util;

import javax.servlet.http.HttpServletRequest;

public class TimeZoneUtil {
    public String parseTimeZone(HttpServletRequest request) {
        if (request.getParameterMap().containsKey("timezone")) {
            return (request.getParameter("timezone").length() < 1) ?
                    "UTC" : request.getParameter("timezone").replace(" ", "+").toUpperCase();
        }
        return "UTC";
    }
}
