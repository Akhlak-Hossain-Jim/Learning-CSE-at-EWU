package com.lifeflow.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Utility for formatting Supabase ISO-8601 timestamps into human-readable strings.
 */
public final class TimeUtils {

    private TimeUtils() {}

    /**
     * Converts an ISO-8601 timestamp (e.g. "2024-01-15T10:30:00+00:00") to a
     * "X minutes ago" / "X hours ago" / "X days ago" string.
     * Falls back to a formatted date if parsing fails.
     */
    public static String getTimeAgo(String isoTimestamp) {
        if (isoTimestamp == null || isoTimestamp.isEmpty()) return "";

        // Normalise offset format: "+00:00" → "+0000" for SimpleDateFormat
        String normalised = isoTimestamp.replaceAll("([+-]\\d{2}):(\\d{2})$", "$1$2");

        String[] formats = {
                "yyyy-MM-dd'T'HH:mm:ssZ",
                "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ",
                "yyyy-MM-dd'T'HH:mm:ssX"
        };

        Date date = null;
        for (String fmt : formats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(fmt, Locale.getDefault());
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                date = sdf.parse(normalised);
                break;
            } catch (ParseException ignored) {}
        }

        if (date == null) return isoTimestamp.substring(0, Math.min(10, isoTimestamp.length()));

        long diffMs   = System.currentTimeMillis() - date.getTime();
        long diffMins = diffMs / 60_000;
        long diffHrs  = diffMins / 60;
        long diffDays = diffHrs / 24;

        if (diffMins < 1)   return "Just now";
        if (diffMins < 60)  return diffMins + " min ago";
        if (diffHrs  < 24)  return diffHrs  + " hr ago";
        if (diffDays < 7)   return diffDays + " day" + (diffDays > 1 ? "s" : "") + " ago";

        SimpleDateFormat display = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        return display.format(date);
    }
}
