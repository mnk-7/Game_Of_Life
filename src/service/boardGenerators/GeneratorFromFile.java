package service.boardGenerators;

import core.boards.Board;
import core.cells.Cell;
import service.FileService;
import validators.FileValidator;

import java.util.List;

public class GeneratorFromFile implements BoardGenerator {

    private final String filePath;
    private final char charForAlive;
    private final char charForDead;

    public GeneratorFromFile(String filePath, char charForAlive, char charForDead) {
        FileValidator.validateAliveAndDeadChars(charForAlive, charForDead);
        this.filePath = filePath;
        this.charForAlive = charForAlive;
        this.charForDead = charForDead;
    }

    public Board createBoard() {
        List<String> lines = FileService.readFile(filePath);

        int rowsNumber = lines.size();
        FileValidator.validateRowsNumber(rowsNumber);

        int columnsNumber = lines.get(0).length();
        FileValidator.validateColumnsNumber(lines);

        Cell[][] cells = createCells(lines, rowsNumber, columnsNumber);

        return new Board(cells);
    }

    private Cell[][] createCells(List<String> lines, int rowsNumber, int columnsNumber) {
        Cell[][] cells = new Cell[rowsNumber][columnsNumber];

        for (int i = 0; i < rowsNumber; i++) {
            String line = lines.get(i);
            Cell tempCell;

            for (int j = 0; j < columnsNumber; j++) {
                char tempChar = line.charAt(j);
                FileValidator.validateChar(tempChar, charForAlive, charForDead);

                if (tempChar == charForAlive) {
                    tempCell = new Cell(true);
                } else {
                    tempCell = new Cell(false);
                }
                cells[i][j] = tempCell;
            }
        }
        return cells;
    }

}