package sg.qi.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ResourceBundle;

public class WaitUtility {

    public static void waitUntil(int second) {
        try {
            Thread.sleep(second * 1000);
        }
        catch (InterruptedException e) {}
    }

    public static boolean waitUntilVisibilityOf(WebElement element, WebDriver in) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("constants");
        int time = Integer.parseInt(resourceBundle.getString("WAIT_TIME"));
        WebDriverWait wait = new WebDriverWait(in, time);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean waitUntilVisibilityOf(By element, WebDriver in) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("constants");
        int time = Integer.parseInt(resourceBundle.getString("WAIT_TIME"));
        WebDriverWait wait = new WebDriverWait(in, time);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

}
