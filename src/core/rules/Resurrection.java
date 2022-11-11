package core.rules;

import core.cells.Cell;
import constants.Condition;

public class Resurrection implements Rule {

    @Override
    public boolean shouldCellChangeState(Cell cell) {
        return !cell.isAlive() && cell.getNumberOfAliveNeighbours() == Condition.RESURRECTION_NEIGHBOURS_NUM;
    }

}