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
public class JackOff extends BotCommand {

    private int timesUsed = 0;
    private static boolean fapping = false;
    private Thread fapThread = new Thread();
    private String[] faps = {"fap",
            "fap fap farp",
            "fap fap",
            "fap fap fap fap",
            "fap fap fap",
            "fap",
            "yesfapyes",
            "yesyesfapyes"
    };

    public JackOff() {
        setName("jackoff");
        setAdminOnly(false);
        setHidden(false);
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);

        if (fapping) {

            fapThread.stop();
            fapping = false;
            timesUsed = 0;

            Resource.message("Fapping stopped!");
            return;
        }

        fapThread = new Thread() {
            @Override
            public void run() {
                while(true) {

                    if (timesUsed >= 18 && fapping) {

                        fapThread.stop();
                        fapping = false;
                        timesUsed = 0;

                        Resource.message("Fapping stopped!");
                        return;
                    }

                    try {
                        Thread.sleep(500);
                        timesUsed++;
                        Resource.message(faps[new Random().nextInt(faps.length)]);
                        fapping = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.stop();
                        fapping = false;
                    }
                }
            }
        };

        fapThread.start();
    }
}
