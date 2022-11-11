package core.rules;

import core.cells.Cell;

public interface Rule {

    boolean shouldCellChangeState(Cell cell);

}