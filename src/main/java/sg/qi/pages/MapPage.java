package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapPage extends BasePage {

    public MapPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[4]/a")
    private WebElement loginPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[4]/a[2]")
    private WebElement registerPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[2]/a")
    private WebElement appPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[2]/a[2]")
    private WebElement galactioPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[3]/a")
    private WebElement storePageLink;

    @FindBy(xpath = "//div[@class='footer']/a")
    private WebElement feedbackPageLink;

    @FindBy(xpath = "//div[@class='footer']/a[2]")
    private WebElement aboutPageLink;

    @FindBy(xpath = "//div[@class='footer']/a[3]")
    private WebElement faqPageLink;

    @FindBy(xpath = "//div[@class='footer']/a[4]")
    private WebElement tncPageLink;

    public void clickOnLoginPageLink() {
        loginPageLink.click();
    }

    public void clickOnRegisterPageLink() {
        registerPageLink.click();
    }

    public void clickOnAppPageLink() {
        appPageLink.click();
    }

    public void clickOnGalactioPageLink() {
        galactioPageLink.click();
    }

    public void clickOnStorePageLink() {
        storePageLink.click();
    }

    public void clickOnFeedbackPageLink() {
        feedbackPageLink.click();
    }

    public void clickOnAboutPageLink() {
        aboutPageLink.click();
    }

    public void clickOnFAQPageLink() {
        faqPageLink.click();
    }

    public void clickOnTnCPageLink() {
        tncPageLink.click();
    }

}