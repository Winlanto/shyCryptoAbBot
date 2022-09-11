package ShyCryptoAbBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ShyCryptoAbBot shyCryptoAbBot = new ShyCryptoAbBot();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new ShyCryptoAbBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("\n"+shyCryptoAbBot.getGreeting());
        System.out.println("CONNECTED TO BOT:");
        for (String s : Arrays.asList("Bot token: " + shyCryptoAbBot.getBotUsername(), "Bot username: " + shyCryptoAbBot.getBotToken(), "Bot base url: " + shyCryptoAbBot.getBaseUrl() + "\n")) {
            System.out.println(s);
        }
    }
}
