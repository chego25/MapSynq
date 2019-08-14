package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class test2 {

    @Given("^today is Monday$")
    public void today_is_Monday() {
        assertEquals("Given", "Given");
    }

    @When("^I ask whether it's Tuesday yet$")
    public void i_ask_whether_it_s_Tuesday_yet() {
        assertEquals("When", "When");
    }

    @Then("^I should be told No$")
    public void i_should_be_told_no() {
        assertEquals("Then", "When");
    }
}
