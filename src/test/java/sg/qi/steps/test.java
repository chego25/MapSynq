package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sg.qi.TestContext;
import sg.qi.pages.LoginPage;
import sg.qi.pages.MapPage;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.*;

public class test {

    private TestContext testContext;

    public test(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        MapPage mapPage = testContext.getPageManager().getMapPage();
        mapPage.clickOnLoginPageLink();
        LoginPage loginPage = testContext.getPageManager().getLoginPage();
        loginPage.clickOnBackwardLink();
        mapPage = testContext.getPageManager().getMapPage();
        mapPage.clickOnLoginPageLink();
        //mapPage.clickOnRegisterPageLink();
        assertEquals("Given", "Given");
        testContext.getDriverManager().getDriver().close();
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() {
        assertEquals("When", "When");
    }

    @Then("^I should be told Yes$")
    public void i_should_be_told_yes() {
        assertEquals("Then", "Then");
    }

}
