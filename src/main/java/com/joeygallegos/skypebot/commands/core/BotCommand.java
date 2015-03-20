package com.joeygallegos.skypebot.commands.core;

import com.joeygallegos.skypebot.util.resources.Resource;
import com.skype.ChatMessage;

import java.util.Arrays;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public abstract class BotCommand {

    private String name;
    private String alias;

    private boolean adminOnly;
    private boolean hidden = false;

    public void run(ChatMessage message, String[] args) throws Exception {
        if (isAdminOnly()) {
            if (!Arrays.asList(Resource.ADMINS).contains(message.getSenderId())) {
                Resource.message("You can't use this command!");
                return;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isAdminOnly() {
        return adminOnly;
    }

    public void setAdminOnly(boolean adminOnly) {
        this.adminOnly = adminOnly;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
