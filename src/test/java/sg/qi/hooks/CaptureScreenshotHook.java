package sg.qi.hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import sg.qi.utilities.AlertUtility;
import sg.qi.utilities.DriverFactory;

public class CaptureScreenshotHook {

    @After
    public void attachScreenshotIfFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getDriver();
            TakesScreenshot screen = (TakesScreenshot) driver;
            try {
                scenario.embed(screen.getScreenshotAs(OutputType.BYTES), "image/png");
            }
            catch (UnhandledAlertException e) {
                AlertUtility.acceptAlert(driver);
                scenario.embed(screen.getScreenshotAs(OutputType.BYTES), "image/png");
            }
        }
    }

}
