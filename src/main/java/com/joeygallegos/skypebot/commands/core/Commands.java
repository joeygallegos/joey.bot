package com.joeygallegos.skypebot.commands.core;

import com.joeygallegos.skypebot.listeners.ChatUtil;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Commands {

    private static List<BotCommand> commands = new ArrayList();
    private static long lastCommand = 0L;

    public static List<BotCommand> getCommands() {
        return commands;
    }

    public static long getLastCommand() {
        return lastCommand;
    }

    public static void parseMessage(ChatMessage message) throws Exception {

        String command = message.getContent();
        System.out.println("Received chat message: " + command);

        if (!command.startsWith(Resource.COMMAND_PREFIX)) {
            ChatUtil.fuckingCheck(message);
            return;
        }

        command = command.substring(1);
        String[] commandSplit = command.split(" ");

        if (commandSplit.length == 0) {
            System.out.println("Nothing found");
            return;
        }

        BotCommand cmd = null;
        for (BotCommand botCommand : getCommands()) {
            if (botCommand.getName().equalsIgnoreCase(commandSplit[0])) {
                cmd = botCommand;
            }
        }

        long difference = System.currentTimeMillis() - getLastCommand();
        if (difference <= 3000L) {
            Resource.message("Please wait before using this again!");
        } else {
            if (cmd != null) {
                lastCommand = System.currentTimeMillis();

                if (cmd.isAdminOnly()) {
                    if (!Arrays.asList(Resource.ADMINS).contains(message.getSenderId())) {
                        Resource.message("You can't use this command!");
                        return;
                    }
                }

                cmd.run(message, (String[]) ArrayUtils.remove(commandSplit, 0));
            } else {
                Resource.message("That command wasn't found!");
            }
        }
    }

}
