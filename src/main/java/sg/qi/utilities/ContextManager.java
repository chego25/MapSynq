package sg.qi.utilities;

import org.openqa.selenium.WebDriver;
import sg.qi.pages.*;

public class ContextManager {

    public ContextManager() {
        this.driver = DriverManager.createDriver();
    }

    private WebDriver driver;
    private AboutPage aboutPage;
    private AppPage appPage;
    private FAQPage faqPage;
    private FeedbackPage feedbackPage;
    private GalactioPage galactioPage;
    private LoginPage loginPage;
    private MapPage mapPage;
    private RegisterPage registerPage;
    private StorePage storePage;
    private TnCPage tncPage;

    public AboutPage getAboutPage() {
        return (aboutPage == null) ? aboutPage = new AboutPage(driver) : aboutPage;
    }

    public AppPage getAppPage() {
        return (appPage == null) ? appPage = new AppPage(driver) : appPage;
    }

    public FAQPage getFaqPage() {
        return (faqPage == null) ? faqPage = new FAQPage(driver) : faqPage;
    }

    public FeedbackPage getFeedbackPage() {
        return (feedbackPage == null) ? feedbackPage = new FeedbackPage(driver) : feedbackPage;
    }

    public GalactioPage getGalactioPage() {
        return (galactioPage == null) ? galactioPage = new GalactioPage(driver) : galactioPage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public MapPage getMapPage() {
        return (mapPage == null) ? mapPage = new MapPage(driver) : mapPage;
    }

    public RegisterPage getRegisterPage() {
        return (registerPage == null) ? registerPage = new RegisterPage(driver) : registerPage;
    }

    public StorePage getStorePage() {
        return (storePage == null) ? storePage = new StorePage(driver) : storePage;
    }

    public TnCPage getTncPage() {
        return (tncPage == null) ? tncPage = new TnCPage(driver) : tncPage;
    }

    public void closeDriver() {
        driver.close();
    }

}
