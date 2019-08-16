package sg.qi.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.assertTrue;

public class MapPageDialogsSteps {

    private MapPage mapPage;

    public MapPageDialogsSteps(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
    }

    @When("^he clicks on the (.*) Dialog link in the Map Page$")
    public void he_clicks_on_the_param_dialog_link_in_the_map_page(String dialogName) {
        try {
            switch (dialogName) {
                case "Feedback": {
                    mapPage.clickOnFeedbackDialogLink();
                    break;
                }
                case "FAQ": {
                    mapPage.clickOnFAQDialogLink();
                    break;
                }
                case "Legend": {
                    mapPage.clickOnLegendDialogLink();
                    break;
                }
                case "Calendar": {
                    mapPage.clickOnCalendarDialogLink();
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Modal \'" + dialogName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("^the (.*) Dialog should be appearing in the UI$")
    public void the_param_dialog_should_be_appearing_in_the_ui(String dialogName) {
        try {
            switch (dialogName) {
                case "Feedback": {
                    assertTrue(mapPage.isFeedbackDialogVisible());
                    break;
                }
                case "FAQ": {
                    assertTrue(mapPage.isFAQDialogVisible());
                    break;
                }
                case "Legend": {
                    assertTrue(mapPage.isLegendDialogVisible());
                    break;
                }
                case "Calendar": {
                    assertTrue(mapPage.isCalendarDialogVisible());
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Modal \'" + dialogName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

}
