package com.joeygallegos.skypebot.commands.util;

import com.joeygallegos.skypebot.commands.core.BotCommand;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Bot extends BotCommand {

    private List<String> messages = new ArrayList<>();

    public Bot() {
        setName("bot");
        setAlias("b");

        messages.add("There are three types of commands: hidden and admin only.");
        messages.add("Each command has a 4 second cooldown that can't be changed");
        messages.add("You can use (" + Resource.COMMAND_PREFIX + "commands) to view all available commands");
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);

        for (String msg : messages) {
            Resource.message(msg);
        }
    }
}
