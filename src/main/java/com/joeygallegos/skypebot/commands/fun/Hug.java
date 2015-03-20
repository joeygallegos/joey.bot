package com.joeygallegos.skypebot.commands.fun;

import com.joeygallegos.skypebot.commands.core.BotCommand;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Hug extends BotCommand {

    public Hug() {
        setName("hug");
        setAlias("hug");
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);
        Resource.message("/me hugs everybody in chat");
    }
}
