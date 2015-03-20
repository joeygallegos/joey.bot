package com.joeygallegos.skypebot.commands.fun;

import com.joeygallegos.skypebot.commands.core.BotCommand;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;

import java.util.Random;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class ShitComboSays extends BotCommand {

    private String[] messages = {
            "*sings*",
            "Queen is so pretty",
            "Anybody wanna play SG?",
            "hi",
            "Hey guys",
            "GG",
            "Hello",
            "This message has been removed.",
            "Can anyone call?",
            "WOW",
            "You cheeky bastard!",
            "XD",
            "Shellie is my idol",
            "Queen is my idol",
            "#ShellieQueenThreeSome"
    };

    public ShitComboSays() {
        setName("shitcombosays");
        setAlias("scs");
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);
        Resource.message(messages[new Random().nextInt(messages.length)]);
    }
}
