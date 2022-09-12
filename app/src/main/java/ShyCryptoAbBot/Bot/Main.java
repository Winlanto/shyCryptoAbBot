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
            botsApi.registerBot(shyCryptoAbBot);
            System.out.println(shyCryptoAbBot.getGreeting());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
