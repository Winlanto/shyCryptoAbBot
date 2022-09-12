package ShyCryptoAbBot.Request;

//REQUESTS
import ShyCryptoAbBot.Request.Ping;
import ShyCryptoAbBot.Request.Connection;

//JSON
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


//JAVA CORE
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class getPing {
    public static Ping run() throws IOException {
        StringBuffer response = new StringBuffer();
        String url = "https://api.coingecko.com/api/v3/ping";
        HttpURLConnection connection=Connection.getConnection(url);
        getStringFromJson(response, connection);
        System.out.println(response);
        Gson g = new GsonBuilder().setLenient().create();
        Ping ping = g.fromJson(response.toString(), Ping.class);
        System.out.println("Response GET /ping: "+ping);
        return ping;
    }



    private static  void getStringFromJson(StringBuffer response, HttpURLConnection connection) throws IOException {
        if(HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
                System.out.println(line);
                response.append("\n");
            }
            /*response.deleteCharAt(0);
            response.deleteCharAt(response.length()-2);*/

            connection.disconnect();
        }
    }
}