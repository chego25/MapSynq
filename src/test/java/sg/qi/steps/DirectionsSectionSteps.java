package sg.qi.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptException;
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

    @Then("^the (.*) Field should have the text \"(.*)\"$")
    public void the_param_field_should_have_the_text_param(String fieldName, String fieldText) {
        try {
            switch (fieldName) {
                case "Source": {
                    assertEquals(fieldText, mapPage.getTextInDirectionsFromField());
                    break;
                }
                case "Destination": {
                    assertEquals(fieldText, mapPage.getTextInDirectionsToField());
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Field \'" + fieldName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @And("^the (.*) Check should have the text \"(.*)\"$")
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

    @And("^he types \"(.*)\" in the (.*) Field$")
    public void he_types_param_in_the_param_field(String fieldText, String fieldName) {
        try {
            switch (fieldName) {
                case "Source": {
                    mapPage.typeInDirectionsFromField(fieldText);
                    break;
                }
                case "Destination": {
                    mapPage.typeInDirectionsToField(fieldText);
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Field \'" + fieldName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException | JavascriptException e) {
            Assert.fail(e.getMessage());
        }
    }

    @And("^he (.*)s the \"(.*)\" option$")
    public void he_params_the_param_option(String checkStatus, String checkName) {
        try {
            switch (checkName) {
                case "Traffic Aware": {
                    switch (checkStatus) {
                        case "select": {
                            if (!mapPage.isDirectionsTrafficChecked()) {
                                mapPage.toggleDirectionsTrafficCheck();
                            }
                            break;
                        }
                        case "deselect": {
                            if (mapPage.isDirectionsTrafficChecked()) {
                                mapPage.toggleDirectionsTrafficCheck();
                            }
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Status \'" + checkStatus + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Toll Aware": {
                    switch (checkStatus) {
                        case "select": {
                            if (!mapPage.isDirectionsTollChecked()) {
                                mapPage.toggleDirectionsTollCheck();
                            }
                            break;
                        }
                        case "deselect": {
                            if (mapPage.isDirectionsTollChecked()) {
                                mapPage.toggleDirectionsTollCheck();
                            }
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
                        case "select": {
                            if (!mapPage.isDirectionsFastestChecked()) {
                                mapPage.toggleDirectionsFastestCheck();
                            }
                            break;
                        }
                        case "deselect": {
                            if (mapPage.isDirectionsFastestChecked()) {
                                mapPage.toggleDirectionsFastestCheck();
                            }
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
                        case "select": {
                            if (!mapPage.isDirectionsShortestChecked()) {
                                mapPage.toggleDirectionsShortestCheck();
                            }
                            break;
                        }
                        case "deselect": {
                            if (mapPage.isDirectionsShortestChecked()) {
                                mapPage.toggleDirectionsShortestCheck();
                            }
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

    @When("^he clicks on the Swap Value button$")
    public void he_clicks_on_the_swap_value_button() {
        try {
            mapPage.swapDirectionFieldEntries();
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("^he clicks on the Clear Route button$")
    public void he_clicks_on_the_clear_route_button() {
        try {
            mapPage.clickOnDirectionsClearLink();
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("^he clicks on the Get Directions button$")
    public void he_clicks_on_the_get_directions_button() {
        try {
            mapPage.clickOnDirectionsSubmitButton();
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("^the Route Search Result should be displayed$")
    public void the_route_search_result_should_be_displayed() {
        assertTrue(mapPage.isDirectionsRouteContainerVisible());
    }

}