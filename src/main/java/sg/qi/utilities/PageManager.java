package sg.qi.utilities;

import sg.qi.pages.*;

public class PageManager {

    private AboutPage aboutPage;
    private AppPage appPage;
    private FAQPage faqPage;
    private FeedbackPage feedbackPage;
    private GalactioPage galactioPage;
    private LoginPage loginPage;
    private MapPage mapPage;
    private PasswordPage passwordPage;
    private RegisterPage registerPage;
    private StorePage storePage;
    private TnCPage tncPage;

    public AboutPage getAboutPage() {
        return (aboutPage == null) ? aboutPage = new AboutPage().get() : aboutPage;
    }

    public AppPage getAppPage() {
        return (appPage == null) ? appPage = new AppPage().get() : appPage;
    }

    public FAQPage getFaqPage() {
        return (faqPage == null) ? faqPage = new FAQPage().get() : faqPage;
    }

    public FeedbackPage getFeedbackPage() {
        return (feedbackPage == null) ? feedbackPage = new FeedbackPage().get() : feedbackPage;
    }

    public GalactioPage getGalactioPage() {
        return (galactioPage == null) ? galactioPage = new GalactioPage().get() : galactioPage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage().get() : loginPage;
    }

    public MapPage getMapPage() {
        return (mapPage == null) ? mapPage = new MapPage().get() : mapPage;
    }

    public PasswordPage getPasswordPage() {
        return (passwordPage == null) ? passwordPage = new PasswordPage().get() : passwordPage;
    }

    public RegisterPage getRegisterPage() {
        return (registerPage == null) ? registerPage = new RegisterPage().get() : registerPage;
    }

    public StorePage getStorePage() {
        return (storePage == null) ? storePage = new StorePage().get() : storePage;
    }

    public TnCPage getTncPage() {
        return (tncPage == null) ? tncPage = new TnCPage().get() : tncPage;
    }

}
