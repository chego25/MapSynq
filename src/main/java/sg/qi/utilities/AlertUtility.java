package sg.qi.utilities;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertUtility {

    public static boolean isAlertPresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

}
