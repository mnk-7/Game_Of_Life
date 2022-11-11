package core.rulesets;

import core.rules.Rule;

import java.util.Set;

public abstract class Ruleset {

    private final Set<Rule> rules;

    public Ruleset(Set<Rule> rules) {
        this.rules = rules;
    }

    public Set<Rule> getRules() {
        return rules;
    }

}