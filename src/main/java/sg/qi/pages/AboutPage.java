package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutPage extends BasePage {

    public AboutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}