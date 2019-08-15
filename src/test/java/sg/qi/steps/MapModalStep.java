package sg.qi.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapModalStep {

    private PageManager pageManager;

    public MapModalStep(DriverManager driverManager, PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @When("^he clicks on the (.*) Modal link in the Map Page$")
    public void he_clicks_on_the_param_modal_link_in_the_Map_page(String modalName) {
        try {
            switch (modalName) {
                case "Feedback": {
                    pageManager.getMapPage().clickOnFeedbackDialogLink();
                    break;
                }
                case "FAQ": {
                    pageManager.getMapPage().clickOnFAQDialogLink();
                    break;
                }
                case "Legend": {
                    pageManager.getMapPage().clickOnLegendDialogLink();
                    break;
                }
                case "Calendar": {
                    pageManager.getMapPage().clickOnCalendarDialogLink();
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
                    assertTrue(pageManager.getMapPage().isFeedbackDialogVisible());
                    break;
                }
                case "FAQ": {
                    assertTrue(pageManager.getMapPage().isFAQDialogVisible());
                    break;
                }
                case "Legend": {
                    assertTrue(pageManager.getMapPage().isLegendDialogVisible());
                    break;
                }
                case "Calendar": {
                    assertTrue(pageManager.getMapPage().isCalendarDialogVisible());
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