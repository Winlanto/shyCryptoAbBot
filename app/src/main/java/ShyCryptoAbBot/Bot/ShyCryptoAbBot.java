package ShyCryptoAbBot.Bot;

//REQUESTS
import ShyCryptoAbBot.Request.Greeting;
import ShyCryptoAbBot.Request.Help;
import ShyCryptoAbBot.Request.Ping;
import ShyCryptoAbBot.Request.Start;


//TELEGRAM
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//JAVA CORE
import java.io.*;
import java.util.*;
import static java.util.Map.entry;

public class ShyCryptoAbBot extends TelegramLongPollingBot {

    public ShyCryptoAbBot() {new Greeting(getBotUsername(), getBotToken(), getBaseUrl());}

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String call = update.getMessage().getText();
            Map<String, ? extends Serializable> sender = Map.ofEntries(
                    entry("id", update.getMessage().getFrom().getId()),
                    entry("username", "@" + update.getMessage().getFrom().getUserName()),
                    entry("firstname", update.getMessage().getFrom().getFirstName())
            );
            ArrayList<String> commands = new ArrayList<>(Arrays.asList("/start", "/help", "/ping"));
            StringBuilder answer = new StringBuilder();
            switch (call) {
                case "/start" -> {
                    new Start(sender, answer);
                    new Help(commands, answer);
                }case "/help" -> {
                    new Help(commands, answer);
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
