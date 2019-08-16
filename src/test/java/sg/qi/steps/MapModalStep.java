package sg.qi.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapModalStep {

    private MapPage mapPage;

    public MapModalStep(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
    }

    @When("^he clicks on the (.*) Modal link in the Map Page$")
    public void he_clicks_on_the_param_modal_link_in_the_Map_page(String modalName) {
        try {
            switch (modalName) {
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
                    throw new UnsupportedCommandException("Modal \'" + modalName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("^the (.*) Modal should be appearing in the UI$")
    public void the_param_modal_should_be_appearing_in_the_UI(String modalName) {
        try {
            switch (modalName) {
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
                    throw new UnsupportedCommandException("Modal \'" + modalName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

}