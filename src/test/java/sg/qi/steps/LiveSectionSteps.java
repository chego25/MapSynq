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

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LiveSectionSteps {

    private MapPage mapPage;

    public LiveSectionSteps(DriverManager driverManager, PageManager pageManager) {
        mapPage = pageManager.getMapPage();
    }

    @Then("^the Live Incidents Sub-Section should be active by default$")
    public void the_live_incidents_sub_section_should_be_active_by_default() {
        try {
            assertTrue(mapPage.isLiveIncidentsSubSectionActive());
            assertEquals("Incidents", mapPage.getLiveIncidentsCheckText());
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("^he clicks on the Live (.*) Sub-Section button$")
    public void the_clicks_on_the_live_param_sub_section_button(String subSectionName) {
        try {
            switch (subSectionName) {
                case "Incidents": {
                    mapPage.clickOnLiveIncidentsCheck();
                    break;
                }
                case "Cameras": {
                    mapPage.clickOnLiveCamerasCheck();
                    break;
                }
                case "Tolls": {
                    mapPage.clickOnLiveTollsCheck();
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Sub-Section \'" + subSectionName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException | JavascriptException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("^the Live (.*) Sub-Section should be activated$")
    public void the_live_param_sub_section_should_be_activated(String subSectionName) {
        try {
            switch (subSectionName) {
                case "Incidents": {
                    assertTrue(mapPage.isLiveIncidentsSubSectionActive());
                    assertEquals("Incidents", mapPage.getLiveIncidentsCheckText());
                    break;
                }
                case "Cameras": {
                    assertTrue(mapPage.isLiveCamerasSubSectionActive());
                    assertEquals("Cameras", mapPage.getLiveCamerasCheckText());
                    break;
                }
                case "Tolls": {
                    assertTrue(mapPage.isLiveTollsSubSectionActive());
                    assertEquals("Tolls", mapPage.getLiveTollsCheckText());
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Sub-Section \'" + subSectionName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @And("^the Live (.*) (.*) Container should be visible")
    public void the_live_param_param_container_should_be_visible(String subSectionName, String containerName) {
        try {
            switch (subSectionName) {
                case "Incidents": {
                    switch (containerName) {
                        case "Singapore": {
                            assertTrue(mapPage.isLiveSingaporeIncidentsVisible());
                            break;
                        }
                        case "Malaysia": {
                            assertTrue(mapPage.isLiveMalaysiaIncidentsVisible());
                            break;
                        }
                        case "Thailand": {
                            assertTrue(mapPage.isLiveThailandIncidentsVisible());
                            break;
                        }
                        case "SriLanka": {
                            assertTrue(mapPage.isLiveSriLankaIncidentsVisible());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Cameras": {
                    switch (containerName) {
                        case "Singapore": {
                            assertTrue(mapPage.isLiveSingaporeCamerasVisible());
                            break;
                        }
                        case "Malaysia": {
                            assertTrue(mapPage.isLiveMalaysiaCamerasVisible());
                            break;
                        }
                        case "Thailand": {
                            assertTrue(mapPage.isLiveThailandCamerasVisible());
                            break;
                        }
                        case "SriLanka": {
                            assertTrue(mapPage.isLiveSriLankaCamerasVisible());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Tolls": {
                    switch (containerName) {
                        case "Singapore": {
                            assertTrue(mapPage.isLiveSingaporeTollsVisible());
                            break;
                        }
                        case "Malaysia": {
                            assertTrue(mapPage.isLiveMalaysiaTollsVisible());
                            break;
                        }
                        case "Thailand": {
                            assertTrue(mapPage.isLiveThailandTollsVisible());
                            break;
                        }
                        case "SriLanka": {
                            assertTrue(mapPage.isLiveSriLankaTollsVisible());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Sub-Section \'" + subSectionName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @And("^the Live (.*) (.*) Container should have title \"(.*)\"")
    public void the_live_param_param_container_should_have_title_param(String subSectionName, String containerName, String titleValue) {
        try {
            switch (subSectionName) {
                case "Incidents": {
                    switch (containerName) {
                        case "Singapore": {
                            assertEquals(titleValue, mapPage.getLiveSingaporeIncidentsHeader());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Cameras": {
                    switch (containerName) {
                        case "Singapore": {
                            assertEquals(titleValue, mapPage.getLiveSingaporeCamerasHeader());
                            break;
                        }
                        case "Malaysia": {
                            assertEquals(titleValue, mapPage.getLiveMalaysiaCamerasHeader());
                            break;
                        }
                        case "SriLanka": {
                            assertEquals(titleValue, mapPage.getLiveSriLankaCamerasHeader());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Tolls": {
                    switch (containerName) {
                        case "Singapore": {
                            assertEquals(titleValue, mapPage.getLiveSingaporeTollsHeader());
                            break;
                        }
                        case "Malaysia": {
                            assertEquals(titleValue, mapPage.getLiveMalaysiaTollsHeader());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Sub-Section \'" + subSectionName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @And("^the Live (.*) (.*) Search Box should have placeholder \"(.*)\"")
    public void the_live_param_param_search_box_should_have_placeholder_param(String subSectionName, String containerName, String placeholderValue) {
        try {
            switch (subSectionName) {
                case "Incidents": {
                    switch (containerName) {
                        case "Singapore": {
                            assertEquals(placeholderValue, mapPage.getLiveSingaporeIncidentsSearchPlaceholder());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Cameras": {
                    switch (containerName) {
                        case "Singapore": {
                            assertEquals(placeholderValue, mapPage.getLiveSingaporeCamerasSearchPlaceholder());
                            break;
                        }
                        case "Malaysia": {
                            assertEquals(placeholderValue, mapPage.getLiveMalaysiaCamerasSearchPlaceholder());
                            break;
                        }
                        case "SriLanka": {
                            assertEquals(placeholderValue, mapPage.getLiveSriLankaCamerasSearchPlaceholder());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                case "Tolls": {
                    switch (containerName) {
                        case "Singapore": {
                            assertEquals(placeholderValue, mapPage.getLiveSingaporeTollsSearchPlaceholder());
                            break;
                        }
                        case "Malaysia": {
                            assertEquals(placeholderValue, mapPage.getLiveMalaysiaTollsSearchPlaceholder());
                            break;
                        }
                        default: {
                            throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                        }
                    }
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Sub-Section \'" + subSectionName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @And("^the Live Incidents (.*) Date Selector List should contain today and the last 3 days")
    public void the_live_incidents_param_date_selector_list_should_contain_today_and_the_last_3_days(String containerName) {
        try {
            switch (containerName) {
                case "Singapore": {
                    String[] dates = mapPage.getLiveSingaporeIncidentsDates();
                    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Singapore"));
                    for (int i = 0; i < dates.length; i++) {
                        if (i == 0) {
                            assertEquals("Today", dates[i]);
                        }
                        else {
                            zonedDateTime = zonedDateTime.minusDays(1);
                            assertEquals(zonedDateTime.format(DateTimeFormatter.ofPattern("dd/MM/uuuu")), dates[i]);
                        }
                    }
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @And("^the Live Incidents (.*) should be ordered in a reverse chronological order")
    public void the_live_incidents_param_should_be_ordered_in_a_reverse_chronological_order(String containerName) {
        try {
            switch (containerName) {
                case "Singapore": {
                    String[] stamps = mapPage.getLiveSingaporeIncidentsStamps();
                    for (int i = 1; i < stamps.length; i++) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.DATE, 1);
                        calendar.set(Calendar.MONTH, 0);
                        calendar.set(Calendar.MONTH, 1970);
                        calendar.set(Calendar.HOUR, Integer.parseInt(stamps[i - 1].split(":")[0]));
                        calendar.set(Calendar.MINUTE, Integer.parseInt(stamps[i - 1].split(":")[1]));
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        Date newStamp = calendar.getTime();
                        calendar = Calendar.getInstance();
                        calendar.set(Calendar.DATE, 1);
                        calendar.set(Calendar.MONTH, 0);
                        calendar.set(Calendar.MONTH, 1970);
                        calendar.set(Calendar.HOUR, Integer.parseInt(stamps[i].split(":")[0]));
                        calendar.set(Calendar.MINUTE, Integer.parseInt(stamps[i].split(":")[1]));
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        Date oldStamp = calendar.getTime();
                        System.out.println("--------");
                        System.out.println("NEW: " + newStamp.getTime());
                        System.out.println("OLD: " + oldStamp.getTime());
                        System.out.println("--------");
                        assertTrue(newStamp.getTime() > oldStamp.getTime());
                    }
                    break;
                }
                default: {
                    throw new UnsupportedCommandException("Container \'" + containerName + "\' is not inside the scope");
                }
            }
        }
        catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

}
