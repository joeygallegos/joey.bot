package com.joeygallegos.skypebot.util;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class TimeUtil {

    public static String calculateTime(long ticks) {

        long days = (int) (ticks / 3600) % 24;
        long hours = ticks / 3600;
        long r = ticks % 3600;
        long mins = r / 60;
        long secs = r % 60;

        if (hours > 24) {
            return days + "d" + hours + "h" + mins + "m" + secs + "s";
        } else if (hours > 0 && hours < 24) {
            return hours + "h" + mins + "m" + secs + "s";
        } else if (mins > 0) {
            return mins + "m" + secs + "s";
        } else {
            return secs + "s";
        }
    }

    public static int timeAgo(long start, long end) {
        long duration = end - start;
        long time = duration / 1000;
        return (int) time;
    }
}
