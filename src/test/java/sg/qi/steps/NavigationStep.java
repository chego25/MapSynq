package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.pages.LoginPage;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.assertEquals;

public class NavigationStep {

    private MapPage mapPage;
    private LoginPage loginPage;

    public NavigationStep(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
        loginPage = pageManager.getLoginPage();
    }

    @Given("^a user is in the (.*) Page of MapSynq application$")
    public void a_user_is_in_the_param_page_of_mapsynq_application(String pageName) {
        switch (pageName) {
            case "Map": {
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
                        mapPage.clickOnLoginPageLink();
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

    @Then("^he should be displayed the (.*) Page of MapSync$")
    public void he_should_be_displayed_the_param_page_of_mapsynq(String pageName) {
        switch (pageName) {
            case "Map": {
                assertEquals("mapSYNQ - Live Traffic Information Platform", mapPage.getTitle());
                break;
            }
            case "Login": {
                assertEquals("mapSYNQ user profile", loginPage.getTitle());
                break;
            }
            default: {
                throw new UnsupportedCommandException("Page \'" + pageName + "\' is not inside the scope");
            }
        }
    }

}