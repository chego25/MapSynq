package sg.qi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import sg.qi.TestContext;
import sg.qi.pages.MapPage;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.assertEquals;

public class FirstLoad {

    private TestContext testContext;

    public FirstLoad(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("^a user tries to open MapSynq application$")
    public void a_user_tries_to_open_mapsynq_application() {
        testContext.getDriverManager().getDriver().navigate().to("http://www.mapsynq.com");
    }

    @Then("^the Map Page should be loaded by default$")
    public void the_map_page_should_be_loaded_by_default() {
        MapPage mapPage = testContext.getPageManager().getMapPage();
        assertEquals("mapSYNQ - Live Traffic Information Platform", mapPage.getTitle());
    }

}
