package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.DriverFactory;

public class PasswordPage extends LoadableComponent<PasswordPage> {

    public PasswordPage() {
        WebDriver driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public String getTitle() {
        return DriverFactory.getDriver().getTitle();
    }

}