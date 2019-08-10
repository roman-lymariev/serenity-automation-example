package framework.steps;

import framework.utils.Variables;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.ScenarioType;


public class VariablesSteps {
    @BeforeScenario(uponType = ScenarioType.ANY)
    public static void resetVariables() {
        Variables.reset();
    }
}
