package core.rules;

import core.cells.Cell;
import constants.Condition;

public class Underpopulation implements Rule {

    @Override
    public boolean shouldCellChangeState(Cell cell) {
        return cell.isAlive() && cell.getNumberOfAliveNeighbours() < Condition.UNDERPOPULATION_NEIGHBOURS_MIN_NUM;
    }

}