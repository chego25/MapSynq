package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TnCPage extends BasePage {

    public TnCPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}