package com.joeygallegos.skypebot.commands.fun;

import com.joeygallegos.skypebot.commands.core.BotCommand;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;

import java.util.Arrays;
import java.util.Random;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class SomethingFun extends BotCommand {

    String[] funShit = {"http://www.madeon.fr/adventuremachine/", "http://en.wikipedia.org/wiki/Acoustic_Kitty"};

    public SomethingFun() {
        setName("somethingFun");
        setAlias("sf");
        setAdminOnly(false);
        setHidden(false);
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        if (args.length == 0) {
            // TODO: Random something
            Resource.message(funShit[new Random().nextInt(funShit.length)]);
        }
        else {
            String cmd = args[0];
            if (cmd.equalsIgnoreCase("add")) {
                if (!Arrays.asList(Resource.ADMINS).contains(message.getSenderId())) {
                    // TODO: Add things
                    // TODO: String builder - regex for link only
                }
            }
            else {
                Resource.message("Sorry, that sub command couldn't be found!");
            }
        }
    }
}
