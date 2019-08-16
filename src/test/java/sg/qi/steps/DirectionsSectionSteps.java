package sg.qi.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
import sg.qi.pages.MapPage;
import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;
import static org.junit.Assert.*;

public class DirectionsSectionSteps {

    private MapPage mapPage;

    public DirectionsSectionSteps(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
    }

    @Then("^the (.*) Check should have the text \"(.*)\"$")
    public void the_param_check_should_have_the_text_param(String checkName, String checkText) {
        try {
            switch (checkName) {
                case "Traffic": {
                    assertEquals(checkText, mapPage.getDirectionsTrafficText());
                    break;
                }
                case "Toll": {
                    assertEquals(checkText, mapPage.getDirectionsTollText());
                    break;
                }
                case "Fastest": {
                    assertEquals(checkText, mapPage.getDirectionsFastestText());
                    break;
                }
                case "Shortest": {
                    assertEquals(checkText, mapPage.getDirectionsShortestText());
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Check \'" + checkName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @And("^the (.*) Check should have the status \"(.*)\"$")
    public void the_param_check_should_have_the_status_param(String checkName, String checkStatus) {
        try {
            switch (checkName) {
                case "Traffic": {
                    switch (checkStatus) {
                        case "checked": {
                            assertTrue(mapPage.isDirectionsTrafficChecked());
                            break;
                        }
                        case "unchecked": {
                            assertFalse(mapPage.isDirectionsTrafficChecked());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Status \'" + checkStatus + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Toll": {
                    switch (checkStatus) {
                        case "checked": {
                            assertTrue(mapPage.isDirectionsTollChecked());
                            break;
                        }
                        case "unchecked": {
                            assertFalse(mapPage.isDirectionsTollChecked());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Status \'" + checkStatus + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Fastest": {
                    switch (checkStatus) {
                        case "checked": {
                            assertTrue(mapPage.isDirectionsFastestChecked());
                            break;
                        }
                        case "unchecked": {
                            assertFalse(mapPage.isDirectionsFastestChecked());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Status \'" + checkStatus + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Shortest": {
                    switch (checkStatus) {
                        case "checked": {
                            assertTrue(mapPage.isDirectionsShortestChecked());
                            break;
                        }
                        case "unchecked": {
                            assertFalse(mapPage.isDirectionsShortestChecked());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Status \'" + checkStatus + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Check \'" + checkName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }
}