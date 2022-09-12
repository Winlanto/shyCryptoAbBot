package ShyCryptoAbBot.Request;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Ping {
    String url = "https://api.coingecko.com/api/v3/ping";
    private String gecko_says;

    public String getGecko_says() {
        return gecko_says;
    }

    public void setGecko_says(String gecko_says) {
        this.gecko_says = gecko_says;
    }

    @Override
    public String toString() { return "Ping{" + "gecko_says=" + gecko_says + '}';}

    public Ping getPing() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Ping ping = new Gson().fromJson(response.body(), Ping.class);
        setGecko_says(ping.getGecko_says());
        return this;
    }
}
