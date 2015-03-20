package com.joeygallegos.skypebot.commands.fun;

import com.joeygallegos.skypebot.commands.core.BotCommand;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Choice extends BotCommand {

    public Choice() {
        setName("choice");
        setAlias("choice");
        setAdminOnly(false);
        setHidden(false);
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        String msg = "";
        for(int i = 0; i < args.length; i++) {
            String arg = args[i] + " ";
            msg = msg + arg;
        }
        String[] choices = msg.trim().split(",");

        if (choices.length == 1) {
            Resource.message("Give me choices!");
            return;
        }

        // SEE NOT FUCKING RIGGED
        Resource.message("I say " + choices[ThreadLocalRandom.current().nextInt(choices.length)].trim());
    }
}
