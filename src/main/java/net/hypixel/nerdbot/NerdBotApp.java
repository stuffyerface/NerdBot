package net.hypixel.nerdbot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.hypixel.nerdbot.api.bot.Bot;
import net.hypixel.nerdbot.bot.NerdBot;
import net.hypixel.nerdbot.util.Logger;

import javax.security.auth.login.LoginException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NerdBotApp {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);
    public static final Gson GSON = new GsonBuilder().create();
    private static Bot bot;

    public static void main(String[] args) {
        NerdBot nerdBot = new NerdBot();
        try {
            nerdBot.create(args);
        } catch (LoginException e) {
            Logger.error("Failed to find login for bot!");
            e.printStackTrace();
            System.exit(0);
            return;
        }
        nerdBot.registerListeners();
        bot = nerdBot;
    }

    public static Bot getBot() {
        return bot;
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
