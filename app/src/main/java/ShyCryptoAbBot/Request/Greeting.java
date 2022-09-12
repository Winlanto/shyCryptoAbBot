package ShyCryptoAbBot.Request;

public class Greeting {

    String botUsername;
    String botToken;
    String botBaseUrl;

    public Greeting(String botUsername, String botToken, String botBaseUrl) {
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.botBaseUrl = botBaseUrl;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "\nJAVA LIVE!" + "\n\nCONNECTED TO BOT:" + ("\nBot token: " + botUsername + "\nBot username: " + botToken + "\nBot base url: " + botBaseUrl + "\n");
    }
}
