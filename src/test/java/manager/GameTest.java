package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exceptions.NotRegisteredException;
import domain.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "One", 10);
    private Player player2 = new Player(2, "Two", 20);
    private Player player3 = new Player(3, "Three", 30);
    private Player player4 = new Player(4, "Four", 40);
    private Player player5 = new Player(5, "Five", 50);
    private Player player6 = new Player(6, "Six", 50);


    @BeforeEach
    void shouldRegisterAllPlayers() {
        game.registerAll(List.of(player1, player2, player3, player4, player5, player6));
    }

    @Test
    void shouldFindAllRegisteredPlayers() {
        assertEquals(List.of(player1, player2, player3, player4, player5, player6), game.findAll());
    }

    @Test
    void shouldFindByNameRegisterPlayer() {
        assertEquals(player4, game.findByName("Four"));
    }

    @Test
    void shouldResultWhenNotRegister() {
        assertNull(game.findByName("Ten"));
    }

    @Test
    void shouldShowIfPlayer1Win() {
        assertEquals(1, game.round("Six", "Two"));
    }

    @Test
    void shouldShowIfPlayer2Win() {
        assertEquals(2, game.round("One", "Five"));
    }

    @Test
    void shouldTwoPlayersInDeadHeat() {
        assertEquals(0, game.round("Five", "Six"));
    }

    @Test
    void shouldIfSecondPlayerNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Three", "Ten"));
    }

    @Test
    void shouldIfFirstPlayerNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Vova", "Five"));
    }

    @Test
    void shouldTwoPlayersNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Terminator", "Batman"));
    }
}