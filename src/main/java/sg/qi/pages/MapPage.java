package sg.qi.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.AlertUtility;
import sg.qi.utilities.DriverFactory;
import sg.qi.utilities.WaitUtility;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MapPage extends LoadableComponent<MapPage> {

    public MapPage() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("constants");
        DriverFactory.getDriver().navigate().to(resourceBundle.getString("APP_URL"));
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @Override
    protected void load() {}

    @Override
    protected void isLoaded() throws Error {
        if (WaitUtility.waitUntilVisibilityOf(addCollapseButton, DriverFactory.getDriver())) {
            WaitUtility.waitUntil(2);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
            javascriptExecutor.executeScript("arguments[0].click();", addCollapseButton);
            WaitUtility.waitUntilVisibilityOf(addExpandButton, DriverFactory.getDriver());
        }
    }

    private void switchDriver() {
        ArrayList<String> tabs = new ArrayList<>(DriverFactory.getDriver().getWindowHandles());
        for (int i = 1; i < tabs.size(); i++) {
            DriverFactory.getDriver().switchTo().window(tabs.get(i));
            DriverFactory.getDriver().close();
        }
        DriverFactory.getDriver().switchTo().window(tabs.get(0));
        if (AlertUtility.isAlertPresent(DriverFactory.getDriver())) {
            AlertUtility.acceptAlert(DriverFactory.getDriver());
        }
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String getTitle() {
        switchDriver();
        return DriverFactory.getDriver().getTitle();
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
    private WebElement calendarDialogLink;

    @FindBy(xpath = "//div[@class='account_bar_wrapper']/div[6]/a[2]")
    private WebElement legendDialogLink;

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

    @FindBy(xpath = "//body/div[7]")
    private WebElement legendDialog;

    @FindBy(xpath = "//body/div[7]/div/a")
    private WebElement legendCloseButton;

    @FindBy(xpath = "//body/div[7]")
    private WebElement calendarDialog;

    @FindBy(xpath = "//body/div[7]/div/a")
    private WebElement calendarCloseButton;

    public void clickOnLoginPageLink() {
        switchDriver();
        loginPageLink.click();
    }

    public void clickOnRegisterPageLink() {
        switchDriver();
        registerPageLink.click();
    }

    public void clickOnAppPageLink() {
        switchDriver();
        appPageLink.click();
    }

    public void clickOnGalactioPageLink() {
        switchDriver();
        galactioPageLink.click();
    }

    public void clickOnStorePageLink() {
        switchDriver();
        storePageLink.click();
    }

    public void clickOnLegendDialogLink() {
        switchDriver();
        legendDialogLink.click();
    }

    public void clickOnCalendarDialogLink() {
        switchDriver();
        calendarDialogLink.click();
    }

    public void clickOnAboutPageLink() {
        switchDriver();
        aboutPageLink.click();
    }

    public void clickOnTnCPageLink() {
        switchDriver();
        tncPageLink.click();
    }

    public void clickOnFeedbackDialogLink() {
        switchDriver();
        feedbackModalLink.click();

    }

    public void clickOnFAQDialogLink() {
        switchDriver();
        faqModalLink.click();
    }

    public boolean isFeedbackDialogVisible() {
        switchDriver();
        return WaitUtility.waitUntilVisibilityOf(modalContainer, DriverFactory.getDriver())
            && WaitUtility.waitUntilVisibilityOf(feedbackInput, DriverFactory.getDriver());
    }

    public boolean isFAQDialogVisible() {
        switchDriver();
        return WaitUtility.waitUntilVisibilityOf(modalContainer, DriverFactory.getDriver())
            && WaitUtility.waitUntilVisibilityOf(faqHeader, DriverFactory.getDriver());
    }

    public boolean isLegendDialogVisible() {
        switchDriver();
        return WaitUtility.waitUntilVisibilityOf(legendDialog, DriverFactory.getDriver())
            && WaitUtility.waitUntilVisibilityOf(legendCloseButton, DriverFactory.getDriver());
    }

    public boolean isCalendarDialogVisible() {
        switchDriver();
        return WaitUtility.waitUntilVisibilityOf(calendarDialog, DriverFactory.getDriver())
            && WaitUtility.waitUntilVisibilityOf(calendarCloseButton, DriverFactory.getDriver());
    }

    // Menu and Sections

    @FindBy(xpath = "//div[@class='left_tab']/a")
    private WebElement directionsSectionButton;

    @FindBy(xpath = "//div[@class='left_tab']/a[2]")
    private WebElement personalSectionButton;

    @FindBy(xpath = "//div[@class='left_tab']/a[3]")
    private WebElement liveSectionButton;

    public void clickOnDirectionsSectionButton() {
        switchDriver();
        String xpath = "//div[@class='left_tab']/a";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
        javascriptExecutor.executeScript(script);
    }

    public void clickOnPersonalSectionButton() {
        switchDriver();
        String xpath = "//div[@class='left_tab']/a[2]";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
        javascriptExecutor.executeScript(script);
    }

    public void clickOnLiveSectionButton() {
        switchDriver();
        String xpath = "//div[@class='left_tab']/a[3]";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
        javascriptExecutor.executeScript(script);
    }

    public boolean isDirectionsSectionActive() {
        switchDriver();
        directionsSectionButton = DriverFactory.getDriver().findElement(By.xpath("//div[@class='left_tab']/a"));
        System.out.println("Directions: " + directionsSectionButton.getAttribute("class"));
        return directionsSectionButton.getAttribute("class").contains("tab_active");
    }

    public boolean isPersonalSectionActive() {
        switchDriver();
        personalSectionButton = DriverFactory.getDriver().findElement(By.xpath("//div[@class='left_tab']/a[2]"));
        System.out.println("Personal: " + personalSectionButton.getAttribute("class"));
        return personalSectionButton.getAttribute("class").contains("tab_active");
    }

    public boolean isLiveSectionActive() {
        switchDriver();
        liveSectionButton = DriverFactory.getDriver().findElement(By.xpath("//div[@class='left_tab']/a[3]"));
        System.out.println("Live: " + liveSectionButton.getAttribute("class"));
        return liveSectionButton.getAttribute("class").contains("tab_active");
    }

    // Directions Section

    @FindBy(xpath = "//input[@id='poi_from']")
    private WebElement directionsFromField;

    @FindBy(xpath = "//input[@id='poi_to']")
    private WebElement directionsToField;

    @FindBy(xpath = "//input[@class='sprite route_swap_button']")
    private WebElement directionsSwapButton;

    @FindBy(xpath = "//div[@id='directions_menu']/table/tbody/tr[3]/td[2]/input")
    private WebElement directionsTrafficCheck;

    @FindBy(xpath = "//div[@id='directions_menu']/table/tbody/tr[3]/td[2]/span")
    private WebElement directionsTrafficText;

    @FindBy(xpath = "//div[@id='directions_menu']/table/tbody/tr[3]/td[3]/input")
    private WebElement directionsTollCheck;

    @FindBy(xpath = "//div[@id='directions_menu']/table/tbody/tr[3]/td[3]/span")
    private WebElement directionsTollText;

    @FindBy(xpath = "//div[@id='directions_menu']/table/tbody/tr[4]/td/input")
    private WebElement directionsFastestCheck;

    @FindBy(xpath = "//div[@id='directions_menu']/table/tbody/tr[4]/td/span")
    private WebElement directionsFastestText;

    @FindBy(xpath = "//div[@id='directions_menu']/table/tbody/tr[4]/td[2]/input")
    private WebElement directionsShortestCheck;

    @FindBy(xpath = "//div[@id='directions_menu']/table/tbody/tr[4]/td[2]/span")
    private WebElement directionsShortestText;

    @FindBy(xpath = "//a[@id='btnClear']")
    private WebElement directionsClearLink;

    @FindBy(xpath = "//input[@id='get_direction']")
    private WebElement directionsSubmitButton;

    @FindBy(xpath = "//div[@id='route_search_result']")
    private WebElement directionsRouteContainer;

    public String getTextInDirectionsFromField() {
        switchDriver();
        clickOnDirectionsSectionButton();
        return directionsFromField.getAttribute("value");
    }

    public void typeInDirectionsFromField(String text) {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsFromField.clear();
        directionsFromField.sendKeys(text);
    }

    public String getTextInDirectionsToField() {
        switchDriver();
        return directionsToField.getAttribute("value");
    }

    public void typeInDirectionsToField(String text) {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsToField.clear();
        directionsToField.sendKeys(text);
    }

    public void swapDirectionFieldEntries() {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsSwapButton.click();
    }

    public String getDirectionsTrafficText() {
        switchDriver();
        clickOnDirectionsSectionButton();
        return directionsTrafficText.getText();
    }

    public boolean isDirectionsTrafficChecked() {
        switchDriver();
        clickOnDirectionsSectionButton();
        try {
            return directionsTrafficCheck.getAttribute("checked").equals("true");
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public void toggleDirectionsTrafficCheck() {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsTrafficCheck.click();
    }

    public String getDirectionsTollText() {
        switchDriver();
        clickOnDirectionsSectionButton();
        return directionsTollText.getText();
    }

    public boolean isDirectionsTollChecked() {
        switchDriver();
        clickOnDirectionsSectionButton();
        try {
            return directionsTollCheck.getAttribute("checked").equals("true");
        }
        catch (NullPointerException e) {
            return false;
        }

    }

    public void toggleDirectionsTollCheck() {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsTollCheck.click();
    }

    public String getDirectionsFastestText() {
        switchDriver();
        clickOnDirectionsSectionButton();
        return directionsFastestText.getText();
    }

    public boolean isDirectionsFastestChecked() {
        switchDriver();
        clickOnDirectionsSectionButton();
        try {
            return directionsFastestCheck.getAttribute("checked").equals("true");
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public void toggleDirectionsFastestCheck() {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsFastestCheck.click();
    }

    public String getDirectionsShortestText() {
        switchDriver();
        clickOnDirectionsSectionButton();
        return directionsShortestText.getText();
    }

    public boolean isDirectionsShortestChecked() {
        switchDriver();
        clickOnDirectionsSectionButton();
        try {
            return directionsShortestCheck.getAttribute("checked").equals("true");
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public void toggleDirectionsShortestCheck() {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsShortestCheck.click();
    }

    public void clickOnDirectionsClearLink() {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsClearLink.click();
    }

    public void clickOnDirectionsSubmitButton() {
        switchDriver();
        clickOnDirectionsSectionButton();
        directionsSubmitButton.click();
    }

    public boolean isDirectionsRouteContainerVisible() {
        if (AlertUtility.isAlertPresent(DriverFactory.getDriver())) {
            return false;
        }
        else {
            try {
                WaitUtility.waitUntilVisibilityOf(directionsRouteContainer, DriverFactory.getDriver());
                return true;
            }
            catch (TimeoutException e) {
                return false;
            }
        }
    }

}