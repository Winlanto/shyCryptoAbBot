package ShyCryptoAbBot.Bot;

//REQUESTS

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

    public String getGreeting() {
        String greeting = "\nJAVA LIVE!";
        greeting += "\n\nCONNECTED TO BOT:";
        greeting += "\nBot token: " + getBotUsername() + "\nBot username: " + getBotToken() + "\nBot base url: " + getBaseUrl() + "\n";
        return greeting;
    }

    @Override
    public void onUpdateReceived(Update update) {
        ArrayList<String> commands = new ArrayList<>(Arrays.asList("/start", "/help", "/test"));
        if (update.hasMessage() && update.getMessage().hasText()) {
            String call = update.getMessage().getText();
            Map<String, ? extends Serializable> sender = Map.ofEntries(
                    entry("id", update.getMessage().getFrom().getId()),
                    entry("username", "@" + update.getMessage().getFrom().getUserName()),
                    entry("firstname", update.getMessage().getFrom().getFirstName())
            );
            StringBuilder answer;
            switch (call) {
                case "/start" -> {
                    answer = new StringBuilder("\uD83D\uDC4B Hey There, " + sender.get("firstname") + "! \uD83D\uDC4B\n\u2708 Welcome aboard! \u2708\n\uD83D\uDC64 " + sender.get("username") + " ID: " + sender.get("id") + " \uD83D\uDC64\n\nYou can control me by sending these commands:");
                    for (String command : commands) answer.append("\n").append(command);
                }case "/help" -> {
                    answer = new StringBuilder("Commands available:");
                    for (String command : commands) answer.append("\n").append(command);
                }case "/test" -> {
                    Ping ping = null;
                    try {
                        ping = new Ping().getPing();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    answer = new StringBuilder(sender.get("firstname") + " requested a quick test!\nCoinGecko ping request: " + ping + "\n");
                    if (ping != null) {
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
