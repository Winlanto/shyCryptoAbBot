package ShyCryptoAbBot;
import org.junit.*;
import static org.junit.Assert.*;

class ShyCryptoAbBotTest {
    ShyCryptoAbBot shyCryptoAbBot;
    @Before public void setUp(){shyCryptoAbBot=new ShyCryptoAbBot();}

    @Test
    public void verifyNoExceptionThrown(){Main.main(new String[]{});}

    @Test
    public void testGetGreeting() { assertNotNull(shyCryptoAbBot.getGreeting(), "JAVA LIVE!");}
}
