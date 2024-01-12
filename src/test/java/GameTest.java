import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javahw.Game;
import ru.netology.javahw.NotRegisteredException;
import ru.netology.javahw.Player;

import javax.xml.namespace.QName;

public class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Player ivan = new Player(2, "Иван", 120);
        Player masha = new Player(1, "Маша", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(masha);
        int actual = game.round("Маша", "Иван" );
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player ivan = new Player(1, "Маша", 120);
        Player masha = new Player(2, "Иван", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(masha);
        int actual = game.round("Маша", "Иван" );
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenStrengthEquals() {
        Player ivan = new Player(2, "Иван", 100);
        Player masha = new Player(1, "Маша", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(masha);
        int actual = game.round("Маша", "Иван" );
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNoExist() {
        Player ivan = new Player(1, "Иван", 120);
        Player masha = new Player(2, "Маша", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(masha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Оля", "Иван")
                );
    }

    @Test
    public void testWhenSecondPlayerNoExist() {
        Player ivan = new Player(1, "Иван", 120);
        Player masha = new Player(2, "Маша", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(masha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Иван", "Оля")
        );
    }




}
