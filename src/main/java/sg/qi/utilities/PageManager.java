package sg.qi.utilities;

import sg.qi.pages.*;

public class PageManager {

    private MapPage mapPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private AppPage appPage;
    private GalactioPage galactioPage;
    private StorePage storePage;
    private AboutPage aboutPage;
    private TnCPage tncPage;
    private PasswordPage passwordPage;

    public MapPage getMapPage() {
        return (mapPage == null) ? mapPage = new MapPage().get() : mapPage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage().get() : loginPage;
    }

    public RegisterPage getRegisterPage() {
        return (registerPage == null) ? registerPage = new RegisterPage().get() : registerPage;
    }

    public AppPage getAppPage() {
        return (appPage == null) ? appPage = new AppPage().get() : appPage;
    }

    public GalactioPage getGalactioPage() {
        return (galactioPage == null) ? galactioPage = new GalactioPage().get() : galactioPage;
    }

    public StorePage getStorePage() {
        return (storePage == null) ? storePage = new StorePage().get() : storePage;
    }

    public AboutPage getAboutPage() {
        return (aboutPage == null) ? aboutPage = new AboutPage().get() : aboutPage;
    }

    public TnCPage getTnCPage() {
        return (tncPage == null) ? tncPage = new TnCPage().get() : tncPage;
    }

    public PasswordPage getPasswordPage() {
        return (passwordPage == null) ? passwordPage = new PasswordPage().get() : passwordPage;
    }

}
