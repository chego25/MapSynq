package sg.qi.utilities;

import sg.qi.pages.*;

public class PageManager {

    public MapPage getMapPage() {
        return new MapPage().get();
    }

    public LoginPage getLoginPage() {
        return new LoginPage().get();
    }

    public RegisterPage getRegisterPage() {
        return new RegisterPage().get();
    }

    public AppPage getAppPage() {
        return new AppPage().get();
    }

    public GalactioPage getGalactioPage() {
        return new GalactioPage().get();
    }

    public StorePage getStorePage() {
        return new StorePage().get();
    }

    public AboutPage getAboutPage() {
        return new AboutPage().get();
    }

    public TnCPage getTnCPage() {
        return new TnCPage().get();
    }

    public PasswordPage getPasswordPage() {
        return new PasswordPage().get();
    }

}
