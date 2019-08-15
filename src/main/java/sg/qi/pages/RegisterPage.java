package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.DriverFactory;
import java.util.ArrayList;

public class RegisterPage extends LoadableComponent<RegisterPage> {

    private WebDriver driver;

    public RegisterPage() {
        driver = DriverFactory.getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < (tabs.size() - 1); i++) {
            driver.switchTo().window(tabs.get(i));
            driver.close();
        }
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public String getTitle() {
        return driver.getTitle();
    }

    @FindBy(xpath = "//div[@class='block_header']/a")
    private WebElement backwardLink;

    @FindBy(xpath = "//div[@class='block_header']/a[3]")
    private WebElement mapPageLink;

    @FindBy(xpath = "//div[@class='block_header']/a[5]")
    private WebElement appPageLink;

    @FindBy(xpath = "//div[@class='block_header']/a[7]")
    private WebElement storePageLink;

    public void clickOnBackwardLink() {
        backwardLink.click();
    }

    public void clickOnMapPageLink() {
        mapPageLink.click();
    }

    public void clickOnAppPageLink() {
        appPageLink.click();
    }

    public void clickOnStorePageLink() {
        storePageLink.click();
    }

}