package sg.qi.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.DriverFactory;
import sg.qi.utilities.WaitUtility;
import java.util.ArrayList;
import java.util.List;
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

    // Links and Navigation

    @FindBy(xpath = "//div[@class='sprite ad_bar_toggle ad_bar_collapse']")
    private WebElement addCollapseButton;

    @FindBy(xpath = "//div[@class='sprite ad_bar_toggle ad_bar_expand']")
    private WebElement addExpandButton;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[2]/a")
    private WebElement appPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[2]/a[2]")
    private WebElement galactioPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[2]/a[3]")
    private WebElement storePageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[4]/a")
    private WebElement loginPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[4]/a[2]")
    private WebElement registerPageLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[6]/a")
    private WebElement legendDialogLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[6]/a[2]")
    private WebElement calendarDialogLink;

    @FindBy(xpath = "//div[@class='footer']/a")
    private WebElement feedbackModalLink;

    @FindBy(xpath = "//div[@class='footer']/a[2]")
    private WebElement aboutPageLink;

    @FindBy(xpath = "//div[@class='footer']/a[3]")
    private WebElement faqModalLink;

    @FindBy(xpath = "//div[@class='footer']/a[4]")
    private WebElement tncPageLink;

    @FindBy(xpath = "//div[@class='pp_pic_holder pp_default']")
    private WebElement modalContainer;

    @FindBy(xpath = "//div[@class='pp_content_container']/form/input")
    private WebElement feedbackInput;

    @FindBy(xpath = "//div[@class='pp_content_container']/header")
    private WebElement faqHeader;

    @FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']")
    private WebElement legendDialog;

    @FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/div/a")
    private WebElement legendCloseButton;

    @FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'][2]")
    private WebElement calendarDialog;

    @FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'][2]/div/a")
    private WebElement calendarCloseButton;

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

    public void clickOnLegendDialogLink() {
        legendDialogLink.click();
    }

    public void clickOnCalendarDialogLink() {
        calendarDialogLink.click();
    }

    public void clickOnAboutPageLink() {
        aboutPageLink.click();
    }

    public void clickOnTnCPageLink() {
        tncPageLink.click();
    }

    public void clickOnFeedbackDialogLink() {
        feedbackModalLink.click();

    }

    public void clickOnFAQDialogLink() {
        faqModalLink.click();
    }

    public boolean isFeedbackDialogVisible() {
        return WaitUtility.waitUntilVisibilityOf(modalContainer, driver) && WaitUtility.waitUntilVisibilityOf(feedbackInput, driver);
    }

    public boolean isFAQDialogVisible() {
        return WaitUtility.waitUntilVisibilityOf(modalContainer, driver) && WaitUtility.waitUntilVisibilityOf(faqHeader, driver);
    }

    public boolean isLegendDialogVisible() {
        return WaitUtility.waitUntilVisibilityOf(legendDialog, driver) && WaitUtility.waitUntilVisibilityOf(legendCloseButton, driver);
    }

    public boolean isCalendarDialogVisible() {
        return WaitUtility.waitUntilVisibilityOf(calendarDialog, driver) && WaitUtility.waitUntilVisibilityOf(calendarCloseButton, driver);
    }

    // Menu and Sections

    @FindBy(xpath = "//div[@class='left_tab']/a")
    private WebElement directionsSectionButton;

    @FindBy(xpath = "//div[@class='left_tab']/a[2]")
    private WebElement personalSectionButton;

    @FindBy(xpath = "//div[@class='left_tab']/a[3]")
    private WebElement liveSectionButton;

    public void clickOnDirectionsSectionButton() {
        String xpath = "//div[@class='left_tab']/a";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(script);
    }

    public void clickOnPersonalSectionButton() {
        String xpath = "//div[@class='left_tab']/a[2]";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(script);
    }

    public void clickOnLiveSectionButton() {
        String xpath = "//div[@class='left_tab']/a[3]";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(script);
    }

    public boolean isDirectionsSectionActive() {
        directionsSectionButton = DriverFactory.getDriver().findElement(By.xpath("//div[@class='left_tab']/a"));
        System.out.println(directionsSectionButton.getAttribute("class"));
        return directionsSectionButton.getAttribute("class").contains("tab_active");
    }

    public boolean isPersonalSectionActive() {
        personalSectionButton = DriverFactory.getDriver().findElement(By.xpath("//div[@class='left_tab']/a[2]"));
        System.out.println(personalSectionButton.getAttribute("class"));
        return personalSectionButton.getAttribute("class").contains("tab_active");
    }

    public boolean isLiveSectionActive() {
        liveSectionButton = DriverFactory.getDriver().findElement(By.xpath("//div[@class='left_tab']/a[3]"));
        System.out.println(liveSectionButton.getAttribute("class"));
        return liveSectionButton.getAttribute("class").contains("tab_active");
    }

}