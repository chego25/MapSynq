package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}