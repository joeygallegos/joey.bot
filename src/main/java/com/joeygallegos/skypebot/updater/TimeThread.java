package com.joeygallegos.skypebot.updater;

import com.joeygallegos.skypebot.util.resources.Resource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class TimeThread extends Thread {

    private static final String FILE_NAME = "updater.json";
    private File file = new File("updater.json");

    public TimeThread() {
        super();
        if (file.exists()) {
            if (file.canRead()) {

            }
        }
        else {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                Resource.message("Created update log file");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
