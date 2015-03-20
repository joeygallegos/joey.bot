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
public class ShouldYouCommand extends BotCommand {

    public ShouldYouCommand() {
        setName("shouldi");
        setAdminOnly(false);
        setHidden(false);
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);

        // NOT FUCKING RIGGED, AGAIN
        String[] options = new String[]{"It is certain", "It is decidedly so", "Without a doubt", "Yes definitely", "You may rely on it", "As I see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy try again", "Ask again later", "Better not tell you now", "Cannot predict now", "Concentrate and ask again", "Don't count on it", "My reply is no", "My sources say no", "Outlook not so good", "Very doubtful"};
        int chosen = ThreadLocalRandom.current().nextInt(options.length);
        Resource.message(options[chosen]);
    }
}
