package com.goit.feature;

import com.goit.feature.util.TimeZoneUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

//@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    private String initTime;

    private final TimeZoneUtil timeZoneUtil = new TimeZoneUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZoneId zid = ZoneId.of(timeZoneUtil.parseTimeZone(req));
        Clock clock = Clock.system(zid);
        initTime = LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern(
                "yyyy-MM-dd hh:mm:ss "
        )) + zid;

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("<h1>" + initTime + "</h1>");
        resp.getWriter().close();
    }
}
