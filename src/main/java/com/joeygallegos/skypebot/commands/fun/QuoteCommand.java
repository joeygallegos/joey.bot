package com.joeygallegos.skypebot.commands.fun;

import com.joeygallegos.skypebot.commands.core.BotCommand;
import com.joeygallegos.skypebot.util.objects.Quote;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class QuoteCommand extends BotCommand {

    private String[] artists = {
            "albert_einstein",
            "",
    };

    private static List<Quote> quotes = new ArrayList();

    static {
        quotes.add(new Quote("Imagination is more important than knowledge.", "Albert Einstein"));
        quotes.add(new Quote("Not everything that counts can be counted, and not everything that can be counted counts.", "Albert Einstein"));
        quotes.add(new Quote("The ideals which have always shone before me and filled me with the joy of living are goodness, beauty, and truth.", "Albert Einstein"));
        quotes.add(new Quote("When you're a student or whatever, and you can't afford a car, or a plane fare, or even a train fare, all you can do is hope that someone will stop and pick you up.", "Douglas Adams"));
    }

    public QuoteCommand() {
        setName("quote");
        setAlias(null);
        setAdminOnly(true);
        setHidden(true);
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);

        Quote quote = quotes.get(new Random().nextInt(quotes.size()));
        if (quote != null) {
            Resource.message("\"" + quote.getQuote() + "\" - " + quote.getAuthor());
        } else {
            Resource.message("Error getting quote!");
        }
    }
}
