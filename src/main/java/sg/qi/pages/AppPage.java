package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.DriverFactory;
import java.util.ArrayList;

public class AppPage extends LoadableComponent<AppPage> {

    private WebDriver driver;

    public AppPage() {
        driver = DriverFactory.getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.toString());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(0));
            driver.close();
            tabs.remove(0);
        }
        driver.switchTo().window(tabs.get(0));
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public String getTitle() {
        return driver.getTitle();
    }

}