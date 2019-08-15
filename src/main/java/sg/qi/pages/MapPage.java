package sg.qi.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.DriverFactory;
import sg.qi.utilities.WaitUtility;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MapPage extends LoadableComponent<MapPage> {

    private WebDriver driver;

    public MapPage() {
        driver = DriverFactory.getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 1; i < tabs.size(); i++) {
            driver.switchTo().window(tabs.get(i));
            driver.close();
        }
        driver.switchTo().window(tabs.get(0));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("constants");
        driver.navigate().to(resourceBundle.getString("APP_URL"));
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        if (WaitUtility.waitUntilVisibilityOf(addCollapseButton, driver)) {
            WaitUtility.waitUntil(2);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();", addCollapseButton);
            WaitUtility.waitUntilVisibilityOf(addExpandButton, driver);
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }

    @FindBy(xpath = "//div[@class='sprite ad_bar_toggle ad_bar_collapse']")
    private WebElement addCollapseButton;

    @FindBy(xpath = "//div[@class='sprite ad_bar_toggle ad_bar_expand']")
    private WebElement addExpandButton;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[4]/a")
    private WebElement loginPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[4]/a[2]")
    private WebElement registerPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[2]/a")
    private WebElement appPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[2]/a[2]")
    private WebElement galactioPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[2]/a[3]")
    private WebElement storePageLink;

    @FindBy(xpath = "//div[@class='footer']/a[2]")
    private WebElement aboutPageLink;

    @FindBy(xpath = "//div[@class='footer']/a[4]")
    private WebElement tncPageLink;

    @FindBy(xpath = "//div[@class='footer']/a")
    private WebElement feedbackModalLink;

    @FindBy(xpath = "//div[@class='footer']/a[3]")
    private WebElement faqModalLink;

    @FindBy(xpath = "//div[@class='pp_pic_holder pp_default']")
    private WebElement modalContainer;

    @FindBy(xpath = "//div[@class='pp_content_container']/form/input")
    private WebElement feedbackInput;

    @FindBy(xpath = "//div[@class='pp_content_container']/header")
    private WebElement faqHeader;

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

    public void clickOnAboutPageLink() {
        aboutPageLink.click();
    }

    public void clickOnTnCPageLink() {
        tncPageLink.click();
    }

    public void clickOnFeedbackModalLink() {
        feedbackModalLink.click();

    }

    public void clickOnFAQModalLink() {
        faqModalLink.click();
    }

    public boolean isFeedbackModalVisible() {
        return WaitUtility.waitUntilVisibilityOf(modalContainer, driver) && WaitUtility.waitUntilVisibilityOf(feedbackInput, driver);
    }

    public boolean isFAQModalVisible() {
        return WaitUtility.waitUntilVisibilityOf(modalContainer, driver) && WaitUtility.waitUntilVisibilityOf(faqHeader, driver);
    }

}