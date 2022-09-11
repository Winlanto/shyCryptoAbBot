package ShyCryptoAbBot.Bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        ShyCryptoAbBot shyCryptoAbBot = new ShyCryptoAbBot();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new ShyCryptoAbBot());
            System.out.println("\n"+shyCryptoAbBot.getGreeting());
            System.out.println("CONNECTED TO BOT:");
            Arrays.asList("Bot token: " + shyCryptoAbBot.getBotUsername(), "Bot username: " + shyCryptoAbBot.getBotToken(), "Bot base url: " + shyCryptoAbBot.getBaseUrl() + "\n").forEach(System.out::println);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
