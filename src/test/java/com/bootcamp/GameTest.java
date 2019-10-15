package com.bootcamp;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

//    @Test
//    public void shouldReturnAValidOutputWhenBothCooperate() {
//        Game game = new Game();
//        String score = game.start(1, 1);
//        assertEquals("+2,+2", score);
//    }
//
//    @Test
//    public void shouldReturnAValidOutputWhenBothCheat() {
//        Game game = new Game();
//        String score = game.start(0, 0);
//        assertEquals("0,0", score);
//    }
//
//    @Test
//    public void shouldReturnAValidOutputWhenPlayer1CheatsPlayer2Cooperates() {
//        Game game = new Game();
//        String score = game.start(0, 1);
//        assertEquals("+3,-1", score);
//    }
//
//    @Test
//    public void shouldReturnAValidOutputWhenPlayer2CheatsPlayer1Cooperates() {
//        Game game = new Game();
//        String score = game.start(1, 0);
//        assertEquals("-1,+3", score);
//    }


    @Test
    public void shouldReturnAValidRoundsFor2Rounds() {
        Player mockedPlayer1 = mock(Player.class);
        Player mockedPlayer2 = mock(Player.class);

        when(mockedPlayer1.play()).thenReturn(Behaviour.Cooperate);
        when(mockedPlayer2.play()).thenReturn(Behaviour.Cooperate);
        Game game = new Game(mockedPlayer1, mockedPlayer2, 2);
        Score score = game.start();
        assertEquals(4, score.getPlayer1Score());
        assertEquals(4, score.getPlayer2Score());
    }

    @Test
    public void shouldReturnAValidCheatMovesFor2Rounds() {
        ScannerWrapper mockScannerWrapper = mock(ScannerWrapper.class);
        Player player1 = new Player(new ConsoleBehaviour(mockScannerWrapper));
        Player player2 = new Player(new CheatBehaviour());
        when(mockScannerWrapper.readInput()).thenReturn("CH","CO");

        Game game = new Game(player1, player2, 2);
        Score score = game.start();
        assertEquals(-1, score.getPlayer1Score());
        assertEquals(3, score.getPlayer2Score());
    }
}