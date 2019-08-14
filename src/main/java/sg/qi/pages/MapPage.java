package sg.qi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapPage {

    private WebDriver driver;

    public MapPage(WebDriver driver) {
        this.driver = driver;
        this.driver.navigate().to("http://www.mapsynq.com/");
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(linkText = "Sign in")
    private WebElement loginPageLink;

    @FindBy(linkText = "Register ")
    private WebElement registerPageLink;

    @FindBy(linkText = "Mobile App")
    private WebElement appPageLink;

    @FindBy(linkText = "Galactio")
    private WebElement galactioPageLink;

    @FindBy(linkText = "SG GPS Navigation")
    private WebElement storePageLink;

    @FindBy(linkText = "Feedback")
    private WebElement feedbackPageLink;

    @FindBy(linkText = "About")
    private WebElement aboutPageLink;

    @FindBy(linkText = "FAQ")
    private WebElement faqPageLink;

    @FindBy(linkText = "Terms and conditions")
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