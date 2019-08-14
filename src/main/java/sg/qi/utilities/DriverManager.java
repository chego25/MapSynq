package sg.qi.utilities;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class DriverManager {

    public static WebDriver createDriver() throws UnsupportedCommandException {
        WebDriver driver;
        String browser = System.getProperty("browser");
        switch (browser) {
            case "chrome": {
                driver = createChromeDriver();
                break;
            }
            case "edge": {
                driver = createEdgeDriver();
                break;
            }
            case "firefox": {
                driver = createFirefoxDriver();
                break;
            }
            case "ie": {
                driver = createIEDriver();
                break;
            }
            case "opera": {
                driver = createOperaDriver();
                break;
            }
            case "safari": {
                driver = createSafariDriver();
                break;
            }
            default: {
                String error = "Environment Variable \'browser\' contains an unsupported value: " + browser;
                throw new UnsupportedCommandException(error);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static ChromeDriver createChromeDriver() {
        String driverPath = getDriverExcutablePath() + "chromedriver";
        if (getOperatingSystem().equals("windows")) {
            driverPath = driverPath + ".exe";
        }
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver(new ChromeOptions());
    }

    private static EdgeDriver createEdgeDriver() {
        String error = "Microsoft Edge Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private static FirefoxDriver createFirefoxDriver() {
        String error = "Mozilla Firefox Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private static InternetExplorerDriver createIEDriver() {
        String error = "Internet Explorer Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private static OperaDriver createOperaDriver() {
        String error = "Opera Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private static SafariDriver createSafariDriver() {
        String error = "Apple Safari Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private static String getOperatingSystem() throws UnsupportedCommandException {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return "windows";
        }
        else if (osName.contains("mac")) {
            return "macintosh";
        }
        else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            return "linux";
        }
        else {
            throw new UnsupportedCommandException("Operating System \'" + osName + "\' is not supported");
        }
    }

    private static String getDriverExcutablePath() throws UnsupportedCommandException {
        String separator = System.getProperty("file.separator");
        String suiteHome = System.getProperty("user.dir");
        ArrayList<String> pathParts = new ArrayList<String>(Arrays.asList(suiteHome.split(separator)));
        pathParts.add("drivers");
        pathParts.add(getOperatingSystem());
        pathParts.add("");
        return String.join(separator, pathParts.toArray(new String[0]));
    }

}
