package service;

import core.boards.Board;
import core.cells.Cell;
import core.rules.Rule;
import core.rulesets.Ruleset;

public class GameOfLifeService {

    private final Board board;
    private final Ruleset ruleset;

    public GameOfLifeService(Board board, Ruleset ruleset) {
        this.board = board;
        this.ruleset = ruleset;
    }

    public void updateAliveAttribute() {
        Cell[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                boolean updateCell = false;
                for (Rule rule : ruleset.getRules()) {
                    if (rule.shouldCellChangeState(cells[i][j])) {
                        updateCell = true;
                        break;
                    }
                }
                cells[i][j].changeState(updateCell);
            }
        }
    }

    public void updateNumberOfAliveNeighbourCells() {
        Cell[][] cells = board.getCells();
        int rowsNumber = cells.length;
        int columnsNumber;
        for (int i = 0; i < rowsNumber; i++) {
            columnsNumber = cells[i].length;
            for (int j = 0; j < columnsNumber; j++) {
                int aliveNeighbours = countAliveNeighbours(cells, i, j, rowsNumber, columnsNumber);
                cells[i][j].setNumberOfAliveNeighbours(aliveNeighbours);
            }
        }
    }

    private static int countAliveNeighbours(Cell[][] cells, int currentRow, int currentColumn, int rowsNumber, int columnsNumber) {
        int aliveNeighbours = 0;

        if (upperCellAlive(cells, currentRow, currentColumn)) {
            aliveNeighbours++;
        }
        if (lowerCellAlive(cells, currentRow, currentColumn, rowsNumber)) {
            aliveNeighbours++;
        }
        if (rightCellAlive(cells, currentRow, currentColumn, columnsNumber)) {
            aliveNeighbours++;
        }
        if (leftCellAlive(cells, currentRow, currentColumn)) {
            aliveNeighbours++;
        }
        if (upperRightCornerAlive(cells, currentRow, currentColumn, columnsNumber)) {
            aliveNeighbours++;
        }
        if (upperLeftCornerAlive(cells, currentRow, currentColumn)) {
            aliveNeighbours++;
        }
        if (lowerRightCornerAlive(cells, currentRow, currentColumn, rowsNumber, columnsNumber)) {
            aliveNeighbours++;
        }
        if (lowerLeftCornerAlive(cells, currentRow, currentColumn, rowsNumber)) {
            aliveNeighbours++;
        }

        return aliveNeighbours;
    }

    private static boolean upperCellAlive(Cell[][] cells, int row, int column) {
        int neighbourRow = row - 1;
        return neighbourRow >= 0 && cells[neighbourRow][column].isAlive();
    }

    private static boolean lowerCellAlive(Cell[][] cells, int row, int column, int rowsNumber) {
        int neighbourRow = row + 1;
        return neighbourRow < rowsNumber && cells[neighbourRow][column].isAlive();
    }

    private static boolean rightCellAlive(Cell[][] cells, int row, int column, int columnsNumber) {
        int neighbourColumn = column + 1;
        return neighbourColumn < columnsNumber && cells[row][neighbourColumn].isAlive();
    }

    private static boolean leftCellAlive(Cell[][] cells, int row, int column) {
        int neighbourColumn = column - 1;
        return neighbourColumn >= 0 && cells[row][neighbourColumn].isAlive();
    }

    private static boolean upperRightCornerAlive(Cell[][] cells, int row, int column, int columnsNumber) {
        int neighbourRow = row - 1;
        int neighbourColumn = column + 1;
        return neighbourRow >= 0 && neighbourColumn < columnsNumber && cells[neighbourRow][neighbourColumn].isAlive();
    }

    private static boolean upperLeftCornerAlive(Cell[][] cells, int row, int column) {
        int neighbourRow = row - 1;
        int neighbourColumn = column - 1;
        return neighbourRow >= 0 && neighbourColumn >= 0 && cells[neighbourRow][neighbourColumn].isAlive();
    }

    private static boolean lowerRightCornerAlive(Cell[][] cells, int row, int column, int rowsNumber, int columnsNumber) {
        int neighbourRow = row + 1;
        int neighbourColumn = column + 1;
        return neighbourRow < rowsNumber && neighbourColumn < columnsNumber && cells[neighbourRow][neighbourColumn].isAlive();
    }

    private static boolean lowerLeftCornerAlive(Cell[][] cells, int row, int column, int rowsNumber) {
        int neighbourRow = row + 1;
        int neighbourColumn = column - 1;
        return neighbourRow < rowsNumber && neighbourColumn >= 0 && cells[neighbourRow][neighbourColumn].isAlive();
    }

}