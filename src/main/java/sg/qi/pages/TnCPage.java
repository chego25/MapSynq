package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.DriverFactory;
import java.util.ArrayList;

public class TnCPage extends LoadableComponent<TnCPage> {

    private WebDriver driver;

    public TnCPage() {
        driver = DriverFactory.getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < (tabs.size() - 1); i++) {
            driver.switchTo().window(tabs.get(i));
            driver.close();
        }
        driver.switchTo().window(tabs.get(tabs.size() - 1));
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