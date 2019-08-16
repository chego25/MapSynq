package sg.qi.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SectionSwitchStep {

    private MapPage mapPage;

    public SectionSwitchStep(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
    }

    @Then("^the Live Section should be active by default$")
    public void the_live_section_should_be_active_by_default() {
        try {
            assertTrue(mapPage.isLiveSectionActive());
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("^he clicks on the (.*) Section button$")
    public void the_clicks_on_the_param_section_button(String sectionName) {
        try {
            switch (sectionName) {
                case "Directions": {
                    mapPage.clickOnDirectionsSectionButton();
                    break;
                }
                case "Personal": {
                    mapPage.clickOnPersonalSectionButton();
                    break;
                }
                case "Live": {
                    mapPage.clickOnLiveSectionButton();
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Section \'" + sectionName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException | JavascriptException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("^the (.*) Section should be activated$")
    public void the_param_section_should_be_activated(String sectionName) {
        try {
            switch (sectionName) {
                case "Directions": {
                    assertTrue(mapPage.isDirectionsSectionActive());
                    break;
                }
                case "Personal": {
                    assertTrue(mapPage.isPersonalSectionActive());
                    break;
                }
                case "Live": {
                    assertTrue(mapPage.isLiveSectionActive());
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Section \'" + sectionName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

}