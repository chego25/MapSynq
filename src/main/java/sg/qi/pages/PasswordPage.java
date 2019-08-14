package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends BasePage {

    public PasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}