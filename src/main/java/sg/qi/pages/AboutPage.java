package sg.qi.pages;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.PageFactory;

public class AboutPage {

    private WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}