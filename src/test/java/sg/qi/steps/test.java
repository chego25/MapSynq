package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import sg.qi.utilities.DriverManager;

import static org.testng.Assert.*;

public class test {

    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        WebDriver driver = DriverManager.createDriver();
        assertEquals("Given", "Given");
        driver.quit();
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() {
        assertEquals("When", "When");
    }

    @Then("^I should be told Yes$")
    public void i_should_be_told_yes() {
        System.out.println("Test - " + Thread.currentThread().getId() + " - " + Thread.currentThread().getName());
        assertEquals("Then", "Then");
    }
}
