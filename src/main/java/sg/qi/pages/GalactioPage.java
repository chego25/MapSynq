package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GalactioPage extends BasePage {

    public GalactioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}