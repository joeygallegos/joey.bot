package com.joeygallegos.skypebot.updater;

import com.joeygallegos.skypebot.BotCore;
import com.joeygallegos.skypebot.util.objects.Update;
import com.joeygallegos.skypebot.util.resources.Resource;
import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright Joey Gallegos {c} 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of Joey Gallegos. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the License, and void any
 * agreements with you, the third party.
 */
public class Updater extends Thread {

    public Updater() { }
    private boolean firstRun = true;
    private List<Integer> updateids = new ArrayList();

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                JSONObject json = readJsonFromUrl("http://joeygallegos.com/bot/updates/updates.json");
                JSONArray updates = json.getJSONArray("updates");

                if (updates == null) return;
                for (int i = 0; i < updates.length(); ++i) {

                    if (this.firstRun) {
                        System.out.println("First run");
                        if (!updateids.contains(i)) {
                            updateids.add(i);
                            System.out.println("Added update id: " + i);
                        }
                    }
                    else {
                        // NOT FIRST RUN
                        if (!updateids.contains(i)) {
                            Resource.message("Found a new update!");
                            BotCore.getInstance().restart();
                            stop();
                            return;
                        }
                    }
                }

                if (this.firstRun) {
                    this.firstRun = false;
                    System.out.println("Loaded " + updates.length() + " updates!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
