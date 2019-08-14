package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppPage extends BasePage {

    public AppPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}