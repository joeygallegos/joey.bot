package com.joeygallegos.skypebot;

import com.joeygallegos.skypebot.commands.core.Commands;
import com.joeygallegos.skypebot.commands.fun.*;
import com.joeygallegos.skypebot.commands.util.*;
import com.joeygallegos.skypebot.listeners.ChatListener;
import com.joeygallegos.skypebot.updater.Updater;
import com.joeygallegos.skypebot.util.Printer;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.Skype;
import com.skype.SkypeException;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class BotCore {

    public static int RESTART_CODE = 0;
    public static int SHUTDOWN_CODE = 1;

    private static BotCore instance;
    private static long startTime = 0L;

    // PRINTER CLASS
    private Printer printer;

    public BotCore() {

        instance = this;

        System.setProperty("skype.api.impl", "x11");
        Skype.setDaemon(false);

        try {
            Skype.setDebug(false);
        } catch (SkypeException e) {
            e.printStackTrace();
        }

        // TODO: Create updater thread
        // TODO: Link with web app for updates

        // UTIL
        Commands.getCommands().add(new Bot());
        Commands.getCommands().add(new RestoreTopic());
        Commands.getCommands().add(new Add());
        Commands.getCommands().add(new Stop());
        Commands.getCommands().add(new Restart());
        Commands.getCommands().add(new Toggle());
        Commands.getCommands().add(new CommandsCommand());
        Commands.getCommands().add(new ShouldYouCommand());

        // FUN
        Commands.getCommands().add(new Hug());
        Commands.getCommands().add(new QuoteCommand());
        Commands.getCommands().add(new WhatWouldSamSay());
        Commands.getCommands().add(new ShitComboSays());
        Commands.getCommands().add(new JackOff());
        Commands.getCommands().add(new Idk());
        Commands.getCommands().add(new What());
        Commands.getCommands().add(new Uptime());
        Commands.getCommands().add(new Subscribe());
        Commands.getCommands().add(new Choice());
        Commands.getCommands().add(new SomethingFun());

        if (Commands.getCommands().size() > 0) {
            System.out.println("There are currently " + Commands.getCommands().size() + " commands registered!");
        }

        try {
            Skype.addChatMessageListener(new ChatListener());
        } catch (SkypeException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // START PRINTER THREAD
        printer = new Printer();
        printer.start();

        Updater updater = new Updater();
        updater.start();

        Resource.message("/me has started");
        startTime = System.currentTimeMillis();
    }

    public static long getStartTime() {
        return startTime;
    }

    public static BotCore getInstance() {
        return instance;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void restart() {
        System.out.println("System restarting bot");
        Resource.message("/me is restarting");

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(RESTART_CODE);
    }

    public void shutdown() {
        System.out.println("System shutting down bot");
        Resource.message("/me is stopping");

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(SHUTDOWN_CODE);
    }
}
