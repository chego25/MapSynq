package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sg.qi.pages.LoginPage;
import sg.qi.pages.MapPage;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.*;

public class test {

    private PageManager pageManager;

    public test(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        MapPage mapPage = pageManager.getMapPage();
        mapPage.clickOnLoginPageLink();
        LoginPage loginPage = pageManager.getLoginPage();
        loginPage.clickOnBackwardLink();
        mapPage = pageManager.getMapPage();
        mapPage.clickOnLoginPageLink();
        //mapPage.clickOnRegisterPageLink();
        assertEquals("Given", "Given");
        pageManager.closeDriver();
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
