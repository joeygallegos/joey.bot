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
public class What extends BotCommand {

    private String[] videos = {"https://youtu.be/wHwyca7gu7E", "https://youtu.be/6Ajhzlq42f0"};

    public What() {
        setName("what");
        setAdminOnly(false);
        setHidden(false);
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);

        Resource.message(videos[new Random().nextInt(videos.length)]);
    }
}
