package ShyCryptoAbBot;
import ShyCryptoAbBot.Bot.Main;
import ShyCryptoAbBot.Bot.ShyCryptoAbBot;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;

class ShyCryptoAbBotTest {
    ShyCryptoAbBot shyCryptoAbBot;
    @Before public void setUp(){shyCryptoAbBot=new ShyCryptoAbBot();}

    @Test
    public void verifyNoExceptionThrown() throws IOException, InterruptedException {
        Main.main(new String[]{});}

    @Test
    public void testGetGreeting() { assertNotNull(shyCryptoAbBot.getGreeting(), "JAVA LIVE!");}
}
