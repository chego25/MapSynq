package sg.qi.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sg.qi.utilities.AlertUtility;
import sg.qi.utilities.DriverFactory;
import sg.qi.utilities.WaitUtility;
import java.util.ArrayList;
import java.util.List;
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
    private WebElement appPageLink1;

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

    public void clickOnAppPageLink1() {
        switchDriver();
        appPageLink1.click();
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

    // Personal Section

    @FindBy(xpath = "//div[@class='onesynq_para']/div[2]/p/a")
    private WebElement appPageLink2;

    @FindBy(xpath = "//div[@class='onesynq_para']/input")
    private WebElement registerPageButton;

    public void clickOnAppPageLink2() {
        switchDriver();
        clickOnPersonalSectionButton();
        appPageLink2.click();
    }

    public void clickOnRegisterPageButton() {
        switchDriver();
        clickOnPersonalSectionButton();
        registerPageButton.click();
    }

    // Live Section

    @FindBy(xpath = "//div[@id='news_menu']/div/label")
    private WebElement liveIncidentsCheck;

    @FindBy(xpath = "//div[@id='news_menu']/div/label/span/h2")
    private WebElement liveIncidentsText;

    @FindBy(xpath = "//div[@id='news_menu']/div/label[2]")
    private WebElement liveCamerasCheck;

    @FindBy(xpath = "//div[@id='news_menu']/div/label[2]/span/h2")
    private WebElement liveCamerasText;

    @FindBy(xpath = "//div[@id='news_menu']/div/label[3]")
    private WebElement liveTollsCheck;

    @FindBy(xpath = "//div[@id='news_menu']/div/label[3]/span/h2")
    private WebElement liveTollsText;

    public boolean isLiveIncidentsSubSectionActive() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return liveIncidentsCheck.getAttribute("class").contains("ui-state-active");
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public void clickOnLiveIncidentsCheck() {
        switchDriver();
        clickOnLiveSectionButton();
        String xpath = "//div[@id='news_menu']/div/label";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
        javascriptExecutor.executeScript(script);
        //liveIncidentsCheck.click();
    }

    public String getLiveIncidentsCheckText() {
        switchDriver();
        clickOnLiveSectionButton();
        return liveIncidentsText.getText();
    }

    public boolean isLiveCamerasSubSectionActive() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return liveCamerasCheck.getAttribute("class").contains("ui-state-active");
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public void clickOnLiveCamerasCheck() {
        switchDriver();
        clickOnLiveSectionButton();
        String xpath = "//div[@id='news_menu']/div/label[2]";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
        javascriptExecutor.executeScript(script);
        //liveIncidentsCheck.click();
    }

    public String getLiveCamerasCheckText() {
        switchDriver();
        clickOnLiveSectionButton();
        return liveCamerasText.getText();
    }

    public boolean isLiveTollsSubSectionActive() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return liveTollsCheck.getAttribute("class").contains("ui-state-active");
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public void clickOnLiveTollsCheck() {
        switchDriver();
        clickOnLiveSectionButton();
        String xpath = "//div[@id='news_menu']/div/label[3]";
        String script = "document.evaluate(\"" + xpath + "\", document, null, "
                + "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
        javascriptExecutor.executeScript(script);
        //liveIncidentsCheck.click();
    }

    public String getLiveTollsCheckText() {
        switchDriver();
        clickOnLiveSectionButton();
        return liveTollsText.getText();
    }

    // Live - Incidents Sub-Section

    @FindBy(xpath = "//div[@id='singaporeIncidents']")
    private WebElement singaporeIncidentsContainer;

    @FindBy(xpath = "//div[@id='singaporeIncidents']/div/h3")
    private WebElement singaporeIncidentsHeader;

    @FindBy(xpath = "//div[@id='malaysiaIncidents']")
    private WebElement malaysiaIncidentsContainer;

    @FindBy(xpath = "//div[@id='thailandIncidents']")
    private WebElement thailandIncidentsContainer;

    @FindBy(xpath = "//div[@id='srilankaIncidents']")
    private WebElement srilankaIncidentsContainer;

    public boolean isLiveSingaporeIncidentsVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return singaporeIncidentsContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public String getLiveSingaporeIncidentsHeader() {
        try {
            return singaporeIncidentsHeader.getText();
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public boolean isLiveMalaysiaIncidentsVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return malaysiaIncidentsContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isLiveThailandIncidentsVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return thailandIncidentsContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isLiveSriLankaIncidentsVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return srilankaIncidentsContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    @FindBy(xpath = "//input[@id='txtSearchIncidentsingapore']")
    private WebElement singaporeIncidentsSearch;

    @FindAll({ @FindBy(xpath = "//select[@id='selIncidentDays']/option") })
    private List<WebElement> singaporeIncidentsDates;

    @FindAll({ @FindBy(xpath = "//ul[@id='search_incident_singapore']/li/a/div/div[2]/div") })
    private List<WebElement> singaporeIncidentsStamps;

    public String getLiveSingaporeIncidentsSearchPlaceholder() {
        try {
            return singaporeIncidentsSearch.getAttribute("placeholder");
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public String[] getLiveSingaporeIncidentsDates() {
        switchDriver();
        clickOnLiveSectionButton();
        String[] dates = new String[singaporeIncidentsDates.size()];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = singaporeIncidentsDates.get(i).getText().trim();
        }
        return dates;
    }

    public String[] getLiveSingaporeIncidentsStamps() {
        switchDriver();
        clickOnLiveSectionButton();
        String[] stamps = new String[singaporeIncidentsStamps.size()];
        for (int i = 0; i < singaporeIncidentsStamps.size(); i++) {
            stamps[i] = singaporeIncidentsStamps.get(i).getText().trim();
        }
        return stamps;
    }

    // Live - Cameras Sub-Section

    @FindBy(xpath = "//div[@id='singaporeCameras']")
    private WebElement singaporeCamerasContainer;

    @FindBy(xpath = "//div[@id='singaporeCameras']/div/h3")
    private WebElement singaporeCamerasHeader;

    @FindBy(xpath = "//div[@id='malaysiaCameras']")
    private WebElement malaysiaCamerasContainer;

    @FindBy(xpath = "//div[@id='malaysiaCameras']/div/h3")
    private WebElement malaysiaCamerasHeader;

    @FindBy(xpath = "//div[@id='thailandCameras']")
    private WebElement thailandCamerasContainer;

    @FindBy(xpath = "//div[@id='srilankaCameras']")
    private WebElement srilankaCamerasContainer;

    @FindBy(xpath = "//div[@id='srilankaCameras']/div/h3")
    private WebElement srilankaCamerasHeader;

    public boolean isLiveSingaporeCamerasVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return singaporeCamerasContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public String getLiveSingaporeCamerasHeader() {
        try {
            return singaporeCamerasHeader.getText();
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public boolean isLiveMalaysiaCamerasVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return malaysiaCamerasContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public String getLiveMalaysiaCamerasHeader() {
        try {
            return malaysiaCamerasHeader.getText();
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public boolean isLiveThailandCamerasVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return thailandCamerasContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isLiveSriLankaCamerasVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return srilankaCamerasContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public String getLiveSriLankaCamerasHeader() {
        try {
            return srilankaCamerasHeader.getText();
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    @FindBy(xpath = "//input[@id='txtSearchCamerasingapore']")
    private WebElement singaporeCamerasSearch;

    @FindAll({ @FindBy(xpath = "//ul[@id='camera_location_singapore']/li/div") })
    private List<WebElement> singaporeCamerasList;

    @FindBy(xpath = "//input[@id='txtSearchCameramalaysia']")
    private WebElement malaysiaCamerasSearch;

    @FindAll({ @FindBy(xpath = "//ul[@id='camera_location_malaysia']/li/div") })
    private List<WebElement> malaysiaCamerasList;

    @FindBy(xpath = "//input[@id='txtSearchCamerasrilanka']")
    private WebElement srilankaCamerasSearch;

    @FindAll({ @FindBy(xpath = "//ul[@id='camera_location_srilanka']/li/div") })
    private List<WebElement> sriLankaCamerasList;

    public String getLiveSingaporeCamerasSearchPlaceholder() {
        try {
            return singaporeCamerasSearch.getAttribute("placeholder");
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public void typeInLiveSingaporeCamerasSearch(String text) {
        singaporeCamerasSearch.sendKeys(text);
    }

    public String[] getLiveSingaporeCamerasList() {
        WaitUtility.waitUntil(2);
        ArrayList<String> cameras = new ArrayList<>();
        for (int i = 0; i < singaporeCamerasList.size(); i++) {
            if (singaporeCamerasList.get(i).getCssValue("display").equals("block")) {
                cameras.add(singaporeCamerasList.get(i).findElement(By.xpath("./a")).getText());
            }
        }
        return cameras.toArray(new String[0]);
    }

    public String getLiveMalaysiaCamerasSearchPlaceholder() {
        try {
            return malaysiaCamerasSearch.getAttribute("placeholder");
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public void typeInLiveMalaysiaCamerasSearch(String text) {
        malaysiaCamerasSearch.sendKeys(text);
    }

    public String[] getLiveMalaysiaCamerasList() {
        WaitUtility.waitUntil(2);
        ArrayList<String> cameras = new ArrayList<>();
        for (int i = 0; i < malaysiaCamerasList.size(); i++) {
            if (malaysiaCamerasList.get(i).getCssValue("display").equals("block")) {
                cameras.add(malaysiaCamerasList.get(i).findElement(By.xpath("./a")).getText());
            }
        }
        return cameras.toArray(new String[0]);
    }

    public String getLiveSriLankaCamerasSearchPlaceholder() {
        try {
            return srilankaCamerasSearch.getAttribute("placeholder");
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public void typeInLiveSriLankaCamerasSearch(String text) {
        srilankaCamerasSearch.sendKeys(text);
    }

    public String[] getLiveSriLankaCamerasList() {
        WaitUtility.waitUntil(2);
        ArrayList<String> cameras = new ArrayList<>();
        for (int i = 0; i < sriLankaCamerasList.size(); i++) {
            if (sriLankaCamerasList.get(i).getCssValue("display").equals("block")) {
                cameras.add(sriLankaCamerasList.get(i).findElement(By.xpath("./a")).getText());
            }
        }
        return cameras.toArray(new String[0]);
    }

    // Live - Tolls Sub-Section

    @FindBy(xpath = "//div[@id='singaporeTolls']")
    private WebElement singaporeTollsContainer;

    @FindBy(xpath = "//div[@id='singaporeTolls']/div")
    private WebElement singaporeTollsHeader;

    @FindBy(xpath = "//div[@id='malaysiaTolls']")
    private WebElement malaysiaTollsContainer;

    @FindBy(xpath = "//div[@id='malaysiaTolls']/div")
    private WebElement malaysiaTollsHeader;

    @FindBy(xpath = "//div[@id='thailandTolls']")
    private WebElement thailandTollsContainer;

    @FindBy(xpath = "//div[@id='srilankaTolls']")
    private WebElement srilankaTollsContainer;

    public boolean isLiveSingaporeTollsVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return singaporeTollsContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public String getLiveSingaporeTollsHeader() {
        try {
            return singaporeTollsHeader.getText();
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public boolean isLiveMalaysiaTollsVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return malaysiaTollsContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public String getLiveMalaysiaTollsHeader() {
        try {
            return malaysiaTollsHeader.getText();
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public boolean isLiveThailandTollsVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return thailandTollsContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isLiveSriLankaTollsVisible() {
        switchDriver();
        clickOnLiveSectionButton();
        try {
            return srilankaTollsContainer.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    @FindBy(xpath = "//input[@id='txtSearchERPsingapore']")
    private WebElement singaporeTollsSearch;

    @FindAll({ @FindBy(xpath = "//ul[@id='erp_locationsingapore']/li/div") })
    private List<WebElement> singaporeTollsList;

    @FindBy(xpath = "//input[@id='txtSearchERPmalaysia']")
    private WebElement malaysiaTollsSearch;

    @FindAll({ @FindBy(xpath = "//ul[@id='erp_locationmalaysia']/li/div") })
    private List<WebElement> malaysiaTollsList;

    public String getLiveSingaporeTollsSearchPlaceholder() {
        try {
            return singaporeTollsSearch.getAttribute("placeholder");
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public void typeInLiveSingaporeTollsSearch(String text) {
        singaporeTollsSearch.sendKeys(text);
    }

    public String[] getLiveSingaporeTollsList() {
        WaitUtility.waitUntil(2);
        ArrayList<String> cameras = new ArrayList<>();
        for (int i = 0; i < singaporeTollsList.size(); i++) {
            if (singaporeTollsList.get(i).getCssValue("display").equals("block")) {
                cameras.add(singaporeTollsList.get(i).findElement(By.xpath("./a")).getText());
            }
        }
        return cameras.toArray(new String[0]);
    }

    public String getLiveMalaysiaTollsSearchPlaceholder() {
        try {
            return malaysiaTollsSearch.getAttribute("placeholder");
        }
        catch (NullPointerException e) {
            return "";
        }
    }

    public void typeInLiveMalaysiaTollsSearch(String text) {
        malaysiaTollsSearch.sendKeys(text);
    }

    public String[] getLiveMalaysiaTollsList() {
        WaitUtility.waitUntil(2);
        ArrayList<String> cameras = new ArrayList<>();
        for (int i = 0; i < malaysiaTollsList.size(); i++) {
            if (malaysiaTollsList.get(i).getCssValue("display").equals("block")) {
                cameras.add(malaysiaTollsList.get(i).findElement(By.xpath("./a")).getText());
            }
        }
        return cameras.toArray(new String[0]);
    }

    // Global Search

    @FindBy(xpath = "//input[@id='txtGlobalSearch']")
    private WebElement mapSynqGlobalSearch;

    @FindBy(xpath = "//span[@class='search_icon sprite']")
    private WebElement mapSynqSearchButton;

    @FindBy(xpath = "//div[@class='search_result sprite']")
    private WebElement mapSynqSearchResult;

    public void typeInLiveMapSynqGlobalSearch(String text) {
        mapSynqGlobalSearch.sendKeys(text);
    }

    public void clickOnMapSynqSearchButton() {
        mapSynqSearchButton.click();
    }

    public boolean isMapSynqSearchResultVisible() {
        return mapSynqSearchResult.isDisplayed();
    }

}