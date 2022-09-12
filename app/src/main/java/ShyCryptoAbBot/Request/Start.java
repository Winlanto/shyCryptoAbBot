package ShyCryptoAbBot.Request;

import java.io.Serializable;
import java.util.Map;

public class Start {
    Map<String, ? extends Serializable> sender;
    String firstname;
    String username;
    Long id;
    StringBuilder answer;

    public Start(Map<String, ? extends Serializable> sender, StringBuilder answer) {
        this.sender = sender;
        this.firstname = (String) sender.get("firstname");
        this.username = (String) sender.get("username");
        this.id = (Long) sender.get("id");
        this.answer = answer.append("\uD83D\uDC4B Hey There, ").append(firstname).append("! \uD83D\uDC4B\n\u2708 Welcome aboard! \u2708\n\uD83D\uDC64 ").append(username).append(" ID: ").append(id).append(" \uD83D\uDC64\n\nYou can control me by sending these commands:\n");
    }
}
