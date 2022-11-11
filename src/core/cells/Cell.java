package core.cells;

public class Cell {

    private boolean isAlive;
    private int numberOfAliveNeighbours;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getNumberOfAliveNeighbours() {
        return numberOfAliveNeighbours;
    }

    public void setNumberOfAliveNeighbours(int numberOfAliveNeighbours) {
        this.numberOfAliveNeighbours = numberOfAliveNeighbours;
    }

    public void changeState(boolean shouldChangeState) {
        if (shouldChangeState) {
            isAlive = !isAlive;
        }
    }

}