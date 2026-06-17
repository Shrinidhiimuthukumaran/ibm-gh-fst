

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rps.*;

public class RpsGameTest{

    GameService service = new GameService();

    @Test
    public void testUserWin() {

        assertEquals(
                1,
                service.determineWinner(
                        "Paper",
                        "Rock"));
    }

    @Test
    public void testComputerWin() {

        assertEquals(
                -1,
                service.determineWinner(
                        "Scissor",
                        "Paper"));
    }

    @Test
    public void testDraw() {

        assertEquals(
                0,
                service.determineWinner(
                        "Rock",
                        "Rock"));
    }

    @Test
    public void testValidChoice() {

        assertDoesNotThrow(() ->
                service.validateChoice("Paper"));
    }

    @Test
    public void testInvalidChoice() {

        assertThrows(
                InvalidChoiceException.class,
                () -> service.validateChoice("Stone"));
    }
}