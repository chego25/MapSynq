package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AboutPage extends LoadableComponent<AboutPage> {

    public AboutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    private WebDriver driver;

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

}