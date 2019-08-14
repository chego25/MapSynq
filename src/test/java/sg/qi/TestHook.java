package sg.qi;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class TestHook {

    @After
    public void doSomethingAfter(Scenario scenario) {
        System.out.println(scenario.getId() + " - " + scenario.getName() + " - " + scenario.getStatus());
    }

}