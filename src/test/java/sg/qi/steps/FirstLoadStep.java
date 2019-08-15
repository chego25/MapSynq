package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.assertEquals;

public class FirstLoadStep {

    private PageManager pageManager;

    public FirstLoadStep(DriverManager driverManager, PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Given("^a user tries to open MapSynq application$")
    public void a_user_tries_to_open_mapsynq_application() {}

    @Then("^the Map Page should be loaded by default$")
    public void the_map_page_should_be_loaded_by_default() {
        assertEquals("mapSYNQ - Live Traffic Information Platform", pageManager.getMapPage().getTitle());
    }

}