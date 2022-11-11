package controller;

import core.boards.Board;
import core.cells.Cell;
import service.boardGenerators.BoardGenerator;
import core.games.Game;
import core.games.GameOfLife;
import constants.Default;
import constants.Error;
import constants.Format;
import constants.Message;

public class GameOfLifeConsoleLauncher implements GameLauncher {

    private final char aliveCharDisplayed;
    private final char deadCharDisplayed;
    private final int rounds;
    private final Game game;

    public GameOfLifeConsoleLauncher(char aliveCharDisplayed, char deadCharDisplayed, int rounds, BoardGenerator boardGenerator) {
        game = new GameOfLife(boardGenerator.createBoard());
        this.aliveCharDisplayed = aliveCharDisplayed;
        this.deadCharDisplayed = deadCharDisplayed;
        this.rounds = rounds;
    }

    @Override
    public void launchGame() {
        System.out.println(Message.MSG_START);
        for (int i = 0; i < rounds; i++) {
            game.play();
            displayBoard(game.getBoard());
            try {
                Thread.sleep(Default.DELAY);
            } catch (InterruptedException e) {
                System.out.println(Error.THREAD_SLEEPING);
            }
        }
        System.out.println(Message.MSG_END);
    }

    private void displayBoard(Board board) {
        Cell[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell temp = cells[i][j];
                if (temp.isAlive()) {
                    System.out.print(Format.FONT_YELLOW + aliveCharDisplayed + " " + Format.FONT_RESET);
                } else {
                    System.out.print(Format.FONT_BLUE + deadCharDisplayed + " " + Format.FONT_RESET);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}