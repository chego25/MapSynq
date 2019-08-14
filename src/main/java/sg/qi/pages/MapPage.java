package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MapPage extends LoadableComponent<MapPage> {

    private WebDriver driver;

    public MapPage(WebDriver driver) {
        this.driver = driver;
        this.driver.navigate().to("http://www.mapsynq.com/");
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected void load() {}

    @Override
    protected void isLoaded() throws Error {
        System.out.println("Map Page Loaded");
    }

}