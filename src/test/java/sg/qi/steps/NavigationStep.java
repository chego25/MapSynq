package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.pages.*;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;

import static org.junit.Assert.assertEquals;

public class NavigationStep {

    private PageManager pageManager;

    public NavigationStep(DriverManager driverManager, PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Given("^a user is in the (.*) Page of MapSynq application$")
    public void a_user_is_in_the_param_page_of_mapsynq_application(String pageName) {
        switch (pageName) {
            case "Map": {
                assertEquals("mapSYNQ - Live Traffic Information Platform", pageManager.getMapPage().getTitle());
                break;
            }
            default: {
                throw new UnsupportedCommandException("Page \'" + pageName + "\' is not inside the scope");
            }
        }
    }

    @When("^he clicks on the (.*) Page link in the (.*) Page$")
    public void he_clicks_on_the_param_page_link_in_the_param_page(String linkName, String pageName) {
        switch (pageName) {
            case "Map": {
                switch (linkName) {
                    case "Login": {
                        pageManager.getMapPage().clickOnLoginPageLink();
                        break;
                    }
                    case "Register": {
                        pageManager.getMapPage().clickOnRegisterPageLink();
                        break;
                    }
                    case "App": {
                        pageManager.getMapPage().clickOnAppPageLink();
                        break;
                    }
                    case "Galactio": {
                        pageManager.getMapPage().clickOnGalactioPageLink();
                        break;
                    }
                    case "Store": {
                        pageManager.getMapPage().clickOnStorePageLink();
                        break;
                    }
                    default: {
                        throw new UnsupportedCommandException("Page \'" + linkName + "\' is not inside the scope");
                    }
                }
                break;
            }
            default: {
                throw new UnsupportedCommandException("Page \'" + pageName + "\' is not inside the scope");
            }
        }
    }

    @Then("^he should be displayed the (.*) Page of MapSynq$")
    public void he_should_be_displayed_the_param_page_of_mapsynq(String pageName) {
        switch (pageName) {
            case "Map": {
                assertEquals("mapSYNQ - Live Traffic Information Platform", pageManager.getMapPage().getTitle());
                break;
            }
            case "Login": {
                assertEquals("mapSYNQ user profile", pageManager.getLoginPage().getTitle());
                break;
            }
            case "Register": {
                assertEquals("mapSYNQ user profile", pageManager.getRegisterPage().getTitle());
                break;
            }
            case "App": {
                assertEquals("mapSYNQ Mobile", pageManager.getAppPage().getTitle());
                break;
            }
            case "Galactio": {
                assertEquals("Galactio", pageManager.getGalactioPage().getTitle());
                break;
            }
            case "Store": {
                assertEquals("Galactio - Navigation & Maps for Urban Mobility - Apps on Google Play", pageManager.getStorePage().getTitle());
                break;
            }
            default: {
                throw new UnsupportedCommandException("Page \'" + pageName + "\' is not inside the scope");
            }
        }
    }

}