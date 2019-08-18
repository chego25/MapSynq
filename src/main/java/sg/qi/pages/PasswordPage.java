package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.DriverFactory;
import java.util.ArrayList;

public class PasswordPage extends LoadableComponent<PasswordPage> {

    public PasswordPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @Override
    protected void load() {}

    @Override
    protected void isLoaded() throws Error {}

    private void switchDriver() {
        ArrayList<String> tabs = new ArrayList<>(DriverFactory.getDriver().getWindowHandles());
        for (int i = 0; i < (tabs.size() - 1); i++) {
            DriverFactory.getDriver().switchTo().window(tabs.get(i));
            DriverFactory.getDriver().close();
        }
        DriverFactory.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String getTitle() {
        this.switchDriver();
        return DriverFactory.getDriver().getTitle();
    }

}