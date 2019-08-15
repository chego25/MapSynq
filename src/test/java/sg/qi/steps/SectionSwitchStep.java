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

public class SectionSwitchStep {

    private PageManager pageManager;

    public SectionSwitchStep(DriverManager driverManager, PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Then("^the Live Section should be active by default$")
    public void the_live_section_should_be_active_by_default() {
        assertTrue(pageManager.getMapPage().isLiveSectionActive());
    }

    @When("^he clicks on the (.*) Section button$")
    public void the_clicks_on_the_param_section_button(String sectionName) {
        try {
            switch (sectionName) {
                case "Directions": {
                    pageManager.getMapPage().clickOnDirectionsSectionButton();
                    break;
                }
                case "Personal": {
                    pageManager.getMapPage().clickOnPersonalSectionButton();
                    break;
                }
                case "Live": {
                    pageManager.getMapPage().clickOnLiveSectionButton();
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

    @Then("^the (.*) Section should be activated$")
    public void the_param_section_should_be_activated(String sectionName) {
        try {
            switch (sectionName) {
                case "Directions": {
                    assertTrue(pageManager.getMapPage().isDirectionsSectionActive());
                    break;
                }
                case "Personal": {
                    assertTrue(pageManager.getMapPage().isPersonalSectionActive());
                    break;
                }
                case "Live": {
                    assertTrue(pageManager.getMapPage().isLiveSectionActive());
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
