package ShyCryptoAbBot.Request;

import java.util.ArrayList;

public class Help {
    ArrayList<String> commands;
    StringBuilder answer;

    public Help(ArrayList<String> commands, StringBuilder answer) {
        this.commands = commands;
        this.answer = answer.append("\uD83E\uDD16 Commands available: \uD83E\uDD16");
        for (String command : commands) answer.append("\n").append(command);
    }
}
