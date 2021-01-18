package ChanceCard;

import Game.*;
import gui_main.GUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleReceiveCashFromPlayersTest {


    @Test
    void receiveCashFromPlayersChanceCard() {
        Game game = new Game();
        game.testStartGame();

        for (Player p : game.getPlayers()) {
            assertEquals(30000, p.getCash());
        }

        SimpleReceiveCashFromPlayers cashFromPlayer = new SimpleReceiveCashFromPlayers("du modtager 200 fra de andre bruh", 200);
        cashFromPlayer.execute(game, game.getGui());

        assertEquals(30400,game.getPlayers()[0].getCash());
        assertEquals(29800,game.getPlayers()[1].getCash());
        assertEquals(29800,game.getPlayers()[2].getCash());

    }

}
