package sg.qi.steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;

public class PersonalSectionSteps {

    private MapPage mapPage;

    public PersonalSectionSteps(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
    }

    @When("^he clicks on the advertised App Page link$")
    public void he_clicks_on_the_advertised_app_page_link() {
        try {
            mapPage.clickOnAppPageLink2();
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("^he clicks on the Register Page Button$")
    public void he_clicks_on_the_register_page_button() {
        try {
            mapPage.clickOnRegisterPageButton();
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

}
