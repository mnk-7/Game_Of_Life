package core.rules;

import core.cells.Cell;
import constants.Condition;

public class Overpopulation implements Rule {

    @Override
    public boolean shouldCellChangeState(Cell cell) {
        return cell.isAlive() && cell.getNumberOfAliveNeighbours() > Condition.OVERPOPULATION_NEIGHBOURS_MAX_NUM;
    }

}