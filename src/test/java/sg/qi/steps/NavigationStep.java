package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
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
        try {
            switch (pageName) {
                case "Map": {
                    break;
                }
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
                default: {
                    throw new UnsupportedCommandException("Page \'" + pageName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("^he clicks on the (.*) Page link in the (.*) Page$")
    public void he_clicks_on_the_param_page_link_in_the_param_page(String linkName, String pageName) {
        try {
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
                        case "About": {
                            pageManager.getMapPage().clickOnAboutPageLink();
                            break;
                        }
                        case "TnC": {
                            pageManager.getMapPage().clickOnTnCPageLink();
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Page \'" + linkName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Login": {
                    switch (linkName) {
                        case "Map": {
                            pageManager.getLoginPage().clickOnMapPageLink();
                            break;
                        }
                        case "App1": {
                            pageManager.getLoginPage().clickOnAppPageMenuLink();
                            break;
                        }
                        case "Store": {
                            pageManager.getLoginPage().clickOnStorePageLink();
                            break;
                        }
                        case "Register": {
                            pageManager.getLoginPage().clickOnRegisterPageLink();
                            break;
                        }
                        case "App2": {
                            pageManager.getLoginPage().clickOnAppPageSecondLink();
                            break;
                        }
                        case "Password": {
                            pageManager.getLoginPage().clickOnPasswordPageLink();
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Page \'" + linkName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Register": {
                    switch (linkName) {
                        case "Map": {
                            pageManager.getRegisterPage().clickOnMapPageLink();
                            break;
                        }
                        case "App": {
                            pageManager.getRegisterPage().clickOnAppPageLink();
                            break;
                        }
                        case "Store": {
                            pageManager.getRegisterPage().clickOnStorePageLink();
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Page \'" + linkName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "App": {
                    switch (linkName) {
                        case "Map": {
                            pageManager.getAppPage().clickOnMapPageLink();
                            break;
                        }
                        case "Store": {
                            pageManager.getAppPage().clickOnStorePageLink();
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
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("^the (.*) Page should have the title \"(.*)\"$")
    public void the_param_page_should_have_the_title_param(String pageName, String pageTitle) {
        if (pageName.equals("Map")) {
            assertEquals(pageTitle, pageManager.getMapPage().getTitle());
        }
        else if (pageName.equals("Login")) {
            assertEquals(pageTitle, pageManager.getLoginPage().getTitle());
        }
        else if (pageName.equals("Register")) {
            assertEquals(pageTitle, pageManager.getRegisterPage().getTitle());
        }
        else if (pageName.equals("App") || pageName.equals("App1") || pageName.equals("App2")) {
            assertEquals(pageTitle, pageManager.getAppPage().getTitle());
        }
        else if (pageName.equals("Galactio")) {
            assertEquals(pageTitle, pageManager.getGalactioPage().getTitle());
        }
        else if (pageName.equals("Store")) {
            assertEquals(pageTitle, pageManager.getStorePage().getTitle());
        }
        else if (pageName.equals("About")) {
            assertEquals(pageTitle, pageManager.getAboutPage().getTitle());
        }
        else if (pageName.equals("TnC")) {
            assertEquals(pageTitle, pageManager.getTnCPage().getTitle());
        }
        else if (pageName.equals("Password")) {
            assertEquals(pageTitle, pageManager.getPasswordPage().getTitle());
        }
        else {
            throw new UnsupportedCommandException("Page \'" + pageName + "\' is not inside the scope");
        }
    }

}