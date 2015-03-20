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
public class WhatWouldSamSay extends BotCommand {

    private String[] messages = {
            "Hey my butt is average size okay? Lol",
            "Why not just make it purple?",
            "http://upld.joeygallegos.com/up/1r1hqd1k1e.jpg",
            "rt if ur a princess",
            "I'm happy and I don't care if you care or not \uD83D\uDE1C\uD83D\uDE0A #fuckyourfeelings #BeHappy",
            "salad tastes pretty good once you add some pizza and get rid of the salad",
            "Joey is a butthole ._. He tweets about me ._.",
            "My little sister is having \"court case\" with a \"jury\" and everything to arrest my dog of attacking her stuffed animals\uD83D\uDE02\uD83D\uDE02I have to pay bail\uD83D\uDE02",
            "don't be upsetti\nhave some spaghetti",
            "I felt a disturbance in the force, who said my name .-.",
            "Almost went down the up escalator at Barnes&Nobles Joey caught me though lol I'm only smart in school \uD83D\uDE02\uD83D\uDE02",
            "I haven’t posted a selfie in a while but I still am very cute just to keep you updated",
            "Hi my name is Samwich_26 and this is Minecraft Cribs ^.^ #mtvparody\n\nhttps://twitter.com/Samwich_26/status/546923299402297345",
            "Procrastination game so strong rn\uD83D\uDE2D\uD83D\uDC4C\uD83D\uDE29\uD83D\uDE2B #ineedhelp",
            "My grandma's driving skills rn are scaring me /.\\ lol",
            "They should cancel school bc it's raining and and I know for sure that the white girls at my school don't want to get their hair or Uggs wet",
            "rt if in a committed relationship with pizza",
            "Why can't my life be like one of the books I've read? \uD83D\uDE2D\uD83D\uDE22\uD83D\uDE2A\uD83D\uDE2B\uD83D\uDE2D",
            "you shouldn't be sad because sad spelled backwards is das and das not good",
            "Can I block people from my life yet ._.\n\nLife>Settings>Block"

    };

    public WhatWouldSamSay() {
        setName("whatwouldsamsay");
        setAlias("wwss");
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);
        Resource.message(messages[new Random().nextInt(messages.length)]);
    }
}
