package ShyCryptoAbBot.Bot;

//REQUESTS

import ShyCryptoAbBot.Request.Greeting;
import ShyCryptoAbBot.Request.Ping;

//JSON

//TELEGRAM
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//JAVA CORE
import java.io.*;
import java.util.*;

import static java.util.Map.entry;

//CLASSES

public class ShyCryptoAbBot extends TelegramLongPollingBot {

    public ShyCryptoAbBot() {
        new Greeting(getBotUsername(), getBotToken(), getBaseUrl());
    }

    @Override
    public void onUpdateReceived(Update update) {
        ArrayList<String> commands = new ArrayList<>(Arrays.asList("/start", "/help", "/ping"));
        if (update.hasMessage() && update.getMessage().hasText()) {
            String call = update.getMessage().getText();
            Map<String, ? extends Serializable> sender = Map.ofEntries(
                    entry("id", update.getMessage().getFrom().getId()),
                    entry("username", "@" + update.getMessage().getFrom().getUserName()),
                    entry("firstname", update.getMessage().getFrom().getFirstName())
            );
            StringBuilder answer = new StringBuilder("error");
            switch (call) {
                case "/start" -> {
                    answer = new StringBuilder("\uD83D\uDC4B Hey There, " + sender.get("firstname") + "! \uD83D\uDC4B\n\u2708 Welcome aboard! \u2708\n\uD83D\uDC64 " + sender.get("username") + " ID: " + sender.get("id") + " \uD83D\uDC64\n\nYou can control me by sending these commands:");
                    for (String command : commands) answer.append("\n").append(command);
                }case "/help" -> {
                    answer = new StringBuilder("Commands available:");
                    for (String command : commands) answer.append("\n").append(command);
                }case "/ping" -> {
                    Ping ping = null;
                    try {
                        ping = new Ping().getPing();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (ping != null) {
                        answer = new StringBuilder(sender.get("firstname") + " requested a quick test!\nCoinGecko ping request:\n" + ping.getGecko_says() + "\n");
                        System.out.println("Response body: " + (ping.getGecko_says()));
                    }
                }default -> answer = new StringBuilder("Sorry, " + sender.get("username") + "!\nThere is no such command as '" + update.getMessage().getText() + "'.\n\nTry:\n/help");
            }
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(answer.toString()
                    .replaceAll(",", "")
                    .replaceAll("]", "")
                    .replaceAll("\\[", "").trim());
            try {
                // Call method to send the message
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "ShyCryptoAbBot";
    }

    @Override
    public String getBotToken() {
        return "5533092397:AAE6JscnbJ7uIefkMOoxbonZTLPYbD5swPw";
    }
}
