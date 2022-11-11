package core.boards;

import core.cells.Cell;

public class Board {

    private final Cell[][] cells;

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

}