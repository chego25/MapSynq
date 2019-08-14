package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
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
        backwardLink.click();
    }

    public void clickOnMapPageLink() {
        mapPageLink.click();
    }

    public void clickOnAppPageMenuLink() {
        appPageMenuLink.click();
    }

    public void clickOnStorePageLink() {
        storePageLink.click();
    }

    public void clickOnAppPageSecondLink() {
        appPageSecondLink.click();
    }

    public void clickOnRegisterPageLink() {
        registerPageLink.click();
    }

    public void clickOnPasswordPageLink() {
        passwordPageLink.click();
    }

}