package com.bootcamp;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    @Test
    public void shouldReturnAValidRoundsFor2Rounds() {
        Player mockedPlayer1 = mock(Player.class);
        Player mockedPlayer2 = mock(Player.class);

        when(mockedPlayer1.play()).thenReturn(Move.Cooperate);
        when(mockedPlayer2.play()).thenReturn(Move.Cooperate);
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
    @Test
    public void shouldReturnAValidResultForCopyCatPlayerAndCheatPlayer() {
        Player cheatPlayer = new Player(new CheatBehaviour());
        Player copycatPlayer = new Player(new CopycatBehavior());

        Game game = new Game(cheatPlayer, copycatPlayer, 2);
        Score score = game.start();
        assertEquals(3, score.getPlayer1Score());
        assertEquals(-1, score.getPlayer2Score());
    }

    @Test
    public void shouldReturnAValidResultForCheatPlayerAndCopycatPlayer() {
        Player copycatPlayer = new Player(new CopycatBehavior());
        Player cheatPlayer = new Player(new CheatBehaviour());

        Game game = new Game(copycatPlayer, cheatPlayer, 2);
        Score score = game.start();
        assertEquals(-1, score.getPlayer1Score());
        assertEquals(3, score.getPlayer2Score());
    }

    @Test
    public void shouldReturnAValidResultForCheatPlayerAndDetectivePlayerForFiveRounds() {
        Player cheatPlayer = new Player(new CheatBehaviour());
        Player detectivePlayer = new Player(new DetectiveBehaviour());

        Game game = new Game(cheatPlayer, detectivePlayer, 5);
        Score score = game.start();
        assertEquals(9, score.getPlayer1Score());
        assertEquals(-3, score.getPlayer2Score());
    }

    @Test
    public void shouldReturnAValidResultForCooperatePlayerAndDetectivePlayerForFiveRounds() {
        Player cooperatePlayer = new Player(new CooperateBehaviour());
        Player detectivePlayer = new Player(new DetectiveBehaviour());

        Game game = new Game(cooperatePlayer, detectivePlayer, 5);
        Score score = game.start();
        assertEquals(7, score.getPlayer1Score());
        assertEquals(11, score.getPlayer2Score());
    }
}
