package com.joeygallegos.skypebot.listeners;

import com.joeygallegos.skypebot.commands.core.Commands;
import com.joeygallegos.skypebot.util.Util;
import com.skype.ChatMessage;
import com.skype.ChatMessageListener;
import com.skype.SkypeException;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class ChatListener implements ChatMessageListener {

    @Override
    public void chatMessageReceived(ChatMessage chatMessage) throws SkypeException {
        try {
            Commands.parseMessage(chatMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Util.serializeMessage(chatMessage));
    }

    @Override
    public void chatMessageSent(ChatMessage chatMessage) throws SkypeException {
        try {
            Commands.parseMessage(chatMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Util.serializeMessage(chatMessage));
    }
}
