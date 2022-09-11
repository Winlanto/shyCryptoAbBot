/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ShyCryptoAbBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;
import java.util.*;
import static java.util.Map.entry;


public class ShyCryptoAbBot extends TelegramLongPollingBot {

    public String getGreeting() {
        return "JAVA LIVE!";
    }

    @Override
    public void onUpdateReceived(Update update) {
        ArrayList<String> commands = new ArrayList<>( Arrays.asList("/start", "/help", "/test"));
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            String request = update.getMessage().getText();
            Map<String, ? extends Serializable> sender = Map.ofEntries(
                    entry("id", update.getMessage().getFrom().getId()),
                    entry("username", "@"+update.getMessage().getFrom().getUserName()),
                    entry("firstname", update.getMessage().getFrom().getFirstName())
            );
            StringBuilder response;
            switch (request) {
                case "/start" -> {
                    response = new StringBuilder("\uD83D\uDC4B Hey There, " + sender.get("firstname") + " \uD83D\uDC4B\n\u2708 Welcome aboard! \u2708\n\uD83D\uDC64 "+sender.get("username")+" ID: "+sender.get("id")+" \uD83D\uDC64\n\nYou can control me by sending these commands:");
                    for (String command : commands) response.append("\n").append(command);
                }
                case "/help" -> {
                    response = new StringBuilder("Commands available:");
                    for (String command : commands) response.append("\n").append(command);
                }
                case "/test" -> response = new StringBuilder(sender.get("firstname") + " requested a quick test!");
                default -> response = new StringBuilder("Sorry, " + sender.get("username") + "!\nThere is no such command as '" + update.getMessage().getText() + "'.\n\nTry:\n/help");
            }
            message.setText(response.toString());
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
