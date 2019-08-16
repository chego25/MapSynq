package sg.qi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.DriverFactory;
import java.util.ArrayList;

public class LoginPage extends LoadableComponent<LoginPage> {

    public LoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    private void switchDriver() {
        ArrayList<String> tabs = new ArrayList<>(DriverFactory.getDriver().getWindowHandles());
        for (int i = 0; i < (tabs.size() - 1); i++) {
            DriverFactory.getDriver().switchTo().window(tabs.get(i));
            DriverFactory.getDriver().close();
        }
        DriverFactory.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String getTitle() {
        this.switchDriver();
        return DriverFactory.getDriver().getTitle();
    }

    @FindBy(xpath = "//div[@class='block_header']/a")
    private WebElement backwardLink;

    @FindBy(xpath = "//div[@class='block_header']/a[3]")
    private WebElement mapPageLink;

    @FindBy(xpath = "//div[@class='block_header']/a[5]")
    private WebElement appPageMenuLink;

    @FindBy(xpath = "//div[@class='block_header']/a[7]")
    private WebElement storePageLink;

    @FindBy(xpath = "//p[@class='margin_0']/a")
    private WebElement appPageSecondLink;

    @FindBy(xpath = "//td[@class='text_create_account']/a")
    private WebElement registerPageLink;

    @FindBy(xpath = "//div[@class='div_signin_buttons']/a")
    private WebElement passwordPageLink;

    public void clickOnBackwardLink() {
        switchDriver();
        backwardLink.click();
    }

    public void clickOnMapPageLink() {
        switchDriver();
        mapPageLink.click();
    }

    public void clickOnAppPageMenuLink() {
        switchDriver();
        appPageMenuLink.click();
    }

    public void clickOnStorePageLink() {
        switchDriver();
        storePageLink.click();
    }

    public void clickOnAppPageSecondLink() {
        switchDriver();
        appPageSecondLink.click();
    }

    public void clickOnRegisterPageLink() {
        switchDriver();
        registerPageLink.click();
    }

    public void clickOnPasswordPageLink() {
        switchDriver();
        passwordPageLink.click();
    }

}