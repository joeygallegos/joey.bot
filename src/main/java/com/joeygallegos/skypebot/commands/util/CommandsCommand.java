package com.joeygallegos.skypebot.commands.util;

import com.joeygallegos.skypebot.commands.core.BotCommand;
import com.joeygallegos.skypebot.commands.core.Commands;
import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class CommandsCommand extends BotCommand {

    public CommandsCommand() {
        setName("commands");
        setAlias("?");
        setAdminOnly(false);
        setHidden(false);
    }

    @Override
    public void run(ChatMessage message, String[] args) throws Exception {
        super.run(message, args);

        String commands = "";
        for (BotCommand command : Commands.getCommands()) {
            if (command.isHidden()) continue;

            if (!commands.equals("")) {
                commands += ", ";
            }
            commands += Resource.COMMAND_PREFIX + command.getName();
        }

        Resource.message("There are " + Commands.getCommands().size() + " Joey Bot Commands:\n\n" + commands);
    }
}
