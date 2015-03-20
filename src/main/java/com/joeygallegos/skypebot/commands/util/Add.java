package com.joeygallegos.skypebot.commands.util;

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
public class Add extends BotCommand {

    public Add() {
        setName("add");
        setAlias("add");
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);
        String link = "https://docs.google.com/document/d/1Aap5DH80sit5aiyH7vTwgnNGjOJjk-WKQ_vW_i44EFQ/edit?usp=sharing";
        Resource.message("Add a suggestion to be added:\n\n" + link);
    }
}
