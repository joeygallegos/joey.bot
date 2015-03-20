package com.joeygallegos.skypebot.listeners;

import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;
import com.skype.SkypeException;

import java.util.Random;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class ChatUtil {

    public static String[] yo = {
            "HEY HEY HEY WATCH IT WITH THE FUCKING WORDS MAN",
            "Yo.., nobody needs to fucking fuck anybody.. Fuck man..",
            "Dude, relax a little",
            "Go to time out, you need stop fucking cussing",
            "WATCH YOUR FUCKING LANGUAGE MAN",
            "YOU NEED TO KNOCK IT THE FUCK OFF MAN",
            "Hey, I'm sorry but FUCKING stop"
    };

    public static void fuckingCheck(ChatMessage message) {
        try {
            if (message.getContent().contains("fucking")) {
                Resource.message(yo[new Random().nextInt(yo.length)]);
            }
        } catch (SkypeException e) {
            e.printStackTrace();
        }
    }

}
