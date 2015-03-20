package com.joeygallegos.skypebot.util.resources;

import com.joeygallegos.skypebot.BotCore;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Resource {

    public static final String VERSION = "0.1";
    public static final String COMMAND_PREFIX = "!";
    public static final String ORIGINAL_TOPIC = "Joey's social chat";
    public static final String[] ADMINS = {"joey.gallegos.97", "joey.bot"};
    private static boolean canPrint = true;

    public static boolean canPrint() {
        return canPrint;
    }

    public static void setCanPrint(boolean b) {
        canPrint = b;
    }

    public static void message(String message) {
        if (canPrint) {
            BotCore.getInstance().getPrinter().getMessageQueue().add(message);
        }
    }
}
