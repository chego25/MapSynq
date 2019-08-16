package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.pages.*;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.assertEquals;

public class PagesNavigationSteps {

    private MapPage mapPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private AppPage appPage;
    private GalactioPage galactioPage;
    private StorePage storePage;
    private AboutPage aboutPage;
    private TnCPage tncPage;
    private PasswordPage passwordPage;

    public PagesNavigationSteps(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
        loginPage = pageManager.getLoginPage();
        registerPage = pageManager.getRegisterPage();
        appPage = pageManager.getAppPage();
        galactioPage = pageManager.getGalactioPage();
        storePage = pageManager.getStorePage();
        aboutPage = pageManager.getAboutPage();
        tncPage = pageManager.getTnCPage();
        passwordPage = pageManager.getPasswordPage();
    }

    @Given("^a user is in the (.*) Page of MapSynq application$")
    public void a_user_is_in_the_param_page_of_mapsynq_application(String pageName) {
        try {
            switch (pageName) {
                case "Map": {
                    break;
                }
                case "Login": {
                    mapPage.clickOnLoginPageLink();
                    break;
                }
                case "Register": {
                    mapPage.clickOnRegisterPageLink();
                    break;
                }
                case "App": {
                    mapPage.clickOnAppPageLink();
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
                            mapPage.clickOnLoginPageLink();
                            break;
                        }
                        case "Register": {
                            mapPage.clickOnRegisterPageLink();
                            break;
                        }
                        case "App": {
                            mapPage.clickOnAppPageLink();
                            break;
                        }
                        case "Galactio": {
                            mapPage.clickOnGalactioPageLink();
                            break;
                        }
                        case "Store": {
                            mapPage.clickOnStorePageLink();
                            break;
                        }
                        case "About": {
                            mapPage.clickOnAboutPageLink();
                            break;
                        }
                        case "TnC": {
                            mapPage.clickOnTnCPageLink();
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
                            loginPage.clickOnMapPageLink();
                            break;
                        }
                        case "App1": {
                            loginPage.clickOnAppPageMenuLink();
                            break;
                        }
                        case "Store": {
                            loginPage.clickOnStorePageLink();
                            break;
                        }
                        case "Register": {
                            loginPage.clickOnRegisterPageLink();
                            break;
                        }
                        case "App2": {
                            loginPage.clickOnAppPageSecondLink();
                            break;
                        }
                        case "Password": {
                            loginPage.clickOnPasswordPageLink();
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
                            registerPage.clickOnMapPageLink();
                            break;
                        }
                        case "App": {
                            registerPage.clickOnAppPageLink();
                            break;
                        }
                        case "Store": {
                            registerPage.clickOnStorePageLink();
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
                            appPage.clickOnMapPageLink();
                            break;
                        }
                        case "Store": {
                            appPage.clickOnStorePageLink();
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
            assertEquals(pageTitle, mapPage.getTitle());
        }
        else if (pageName.equals("Login")) {
            assertEquals(pageTitle, loginPage.getTitle());
        }
        else if (pageName.equals("Register")) {
            assertEquals(pageTitle, registerPage.getTitle());
        }
        else if (pageName.equals("App") || pageName.equals("App1") || pageName.equals("App2")) {
            assertEquals(pageTitle, appPage.getTitle());
        }
        else if (pageName.equals("Galactio")) {
            assertEquals(pageTitle, galactioPage.getTitle());
        }
        else if (pageName.equals("Store")) {
            assertEquals(pageTitle, storePage.getTitle());
        }
        else if (pageName.equals("About")) {
            assertEquals(pageTitle, aboutPage.getTitle());
        }
        else if (pageName.equals("TnC")) {
            assertEquals(pageTitle, tncPage.getTitle());
        }
        else if (pageName.equals("Password")) {
            assertEquals(pageTitle, passwordPage.getTitle());
        }
        else {
            throw new UnsupportedCommandException("Page \'" + pageName + "\' is not inside the scope");
        }
    }

}
