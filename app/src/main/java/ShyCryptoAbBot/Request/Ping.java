package ShyCryptoAbBot.Request;

public class Ping {
    private int gecko_says;

    public int getGecko_says() {
        return gecko_says;
    }

    public void setGecko_says(int gecko_says) {
        this.gecko_says = gecko_says;
    }

    @Override
    public String toString() {
        return "Ping{" +
                "gecko_says=" + gecko_says +
                '}';
    }
}
