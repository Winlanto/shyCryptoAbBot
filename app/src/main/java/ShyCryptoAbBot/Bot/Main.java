package ShyCryptoAbBot.Bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        ShyCryptoAbBot shyCryptoAbBot = new ShyCryptoAbBot();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(shyCryptoAbBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
