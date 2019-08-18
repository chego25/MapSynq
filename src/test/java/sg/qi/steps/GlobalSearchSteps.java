package sg.qi.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.assertTrue;

public class GlobalSearchSteps {

    private MapPage mapPage;

    public GlobalSearchSteps(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
    }

    @And("^he types the string \"(.*)\" in the Global Search Field$")
    public void he_types_param_in_the_global_search_field(String searchText) {
        try {
            mapPage.typeInLiveMapSynqGlobalSearch(searchText);
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("^he clicks on the MapSynq Global Search Button$")
    public void he_clicks_on_the_mapsynq_global_search_button() {
        try {
            mapPage.clickOnMapSynqSearchButton();
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("^the MapSynq Global Search result should be displayed$")
    public void the_mapsynq_global_search_result_should_be_displayed() {
        try {
            assertTrue(mapPage.isMapSynqSearchResultVisible());
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

}
