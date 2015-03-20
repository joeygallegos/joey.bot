package com.joeygallegos.skypebot.util;

import com.skype.ChatMessage;
import com.skype.SkypeException;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Util {

    public static String serializeMessage(ChatMessage message) {
        String s = "";
        try {
            s += "[" + message.getTime().toString() + "] " + message.getSenderDisplayName() + ": " + message.getContent();
        } catch (SkypeException e) {
            e.printStackTrace();
        }
        return s;
    }

}
