package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.assertEquals;

public class MapSynqFirstLoadSteps {

    private MapPage mapPage;

    public MapSynqFirstLoadSteps(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
    }

    @Given("^a user tries to open MapSynq application$")
    public void a_user_tries_to_open_mapsynq_application() {}

    @Then("^the Map Page should be loaded by default$")
    public void the_map_page_should_be_loaded_by_default() {
        assertEquals("mapSYNQ - Live Traffic Information Platform", mapPage.getTitle());
    }

}