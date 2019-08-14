package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage extends BasePage {

    public FeedbackPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}