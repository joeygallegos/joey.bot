package com.joeygallegos.skypebot.commands.util;

import com.joeygallegos.skypebot.BotCore;
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
public class Restart extends BotCommand {

    public Restart() {
        setName("restart");
        setAlias("restart");
        setAdminOnly(true);
        setHidden(true);
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);

        BotCore.getInstance().restart();
    }
}
