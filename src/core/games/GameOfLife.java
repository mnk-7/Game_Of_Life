package core.games;

import core.boards.Board;
import core.rulesets.GameOfLifeRuleset;
import service.GameOfLifeService;

public class GameOfLife extends Game {

    private boolean isBoardInitialized;
    private final GameOfLifeService service;

    public GameOfLife(Board board) {
        super(new GameOfLifeRuleset(), board);
        isBoardInitialized = false;
        service = new GameOfLifeService(super.getBoard(), super.getRuleset());
    }

    @Override
    public void play() {
        if (!isBoardInitialized){
            performFirstMove();
            isBoardInitialized = true;
        } else {
            performNextMove();
        }
    }

    private void performFirstMove(){
        service.updateNumberOfAliveNeighbourCells();
    }

    private void performNextMove() {
        service.updateAliveAttribute();
        service.updateNumberOfAliveNeighbourCells();
    }

}