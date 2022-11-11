package core.rulesets;

import core.rules.Overpopulation;
import core.rules.Resurrection;
import core.rules.Underpopulation;

import java.util.Set;

public class GameOfLifeRuleset extends Ruleset {

    public GameOfLifeRuleset() {
        super(Set.of(new Underpopulation(), new Overpopulation(), new Resurrection()));
    }

}