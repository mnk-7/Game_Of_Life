package core.games;

import core.boards.Board;
import core.rulesets.Ruleset;

public abstract class Game {

    private final Board board;
    private final Ruleset ruleset;

    public Game(Ruleset ruleset, Board board) {
        this.ruleset = ruleset;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public Ruleset getRuleset() {
        return ruleset;
    }

    public abstract void play();

}