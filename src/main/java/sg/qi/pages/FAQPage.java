package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FAQPage extends BasePage {

    public FAQPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}