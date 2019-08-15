package sg.qi.utilities;

import sg.qi.pages.*;

public class PageManager {

    public AboutPage getAboutPage() {
        return new AboutPage().get();
    }

    public AppPage getAppPage() {
        return new AppPage().get();
    }

    public FAQPage getFaqPage() {
        return new FAQPage().get();
    }

    public FeedbackPage getFeedbackPage() {
        return new FeedbackPage().get();
    }

    public GalactioPage getGalactioPage() {
        return new GalactioPage().get();
    }

    public LoginPage getLoginPage() {
        return new LoginPage().get();
    }

    public MapPage getMapPage() {
        return new MapPage().get();
    }

    public PasswordPage getPasswordPage() {
        return new PasswordPage().get();
    }

    public RegisterPage getRegisterPage() {
        return new RegisterPage().get();
    }

    public StorePage getStorePage() {
        return new StorePage().get();
    }

    public TnCPage getTncPage() {
        return new TnCPage().get();
    }

}
