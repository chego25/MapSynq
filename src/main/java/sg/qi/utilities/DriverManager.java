package sg.qi.utilities;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import java.util.ArrayList;
import java.util.Arrays;

public class DriverManager {

    public DriverManager() throws UnsupportedCommandException {
        if (DriverFactory.getDriver() == null) {
            String browser = System.getProperty("browser");
            WebDriver driver = null;
            try {
                switch (browser) {
                    case "chrome": {
                        driver = getChromeDriver();
                        break;
                    }
                    case "firefox": {
                        driver = getFirefoxDriver();
                        break;
                    }
                    case "ie": {
                        driver = getInternetExplorerDriver();
                        break;
                    }
                    case "edge": {
                        driver = getEdgeDriver();
                        break;
                    }
                    case "safari": {
                        driver = getSafariDriver();
                        break;
                    }
                }
                driver.manage().window().maximize();
                DriverFactory.addDriver(driver);
            }
            catch (NullPointerException e) {
                String error = "Environment Variable \'browser\' contains an invalid value: " + browser;
                throw new UnsupportedCommandException(error);
            }
        }
    }

    private ChromeDriver getChromeDriver() throws UnsupportedCommandException {
        String driverPath = getExecutablePath() + "chromedriver-" + getSystemArchitecture();
        if (getOperatingSystem().equals("windows")) {
            driverPath = driverPath + ".exe";
        }
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        return new ChromeDriver(chromeOptions);
    }

    private FirefoxDriver getFirefoxDriver() throws UnsupportedCommandException {
        String driverPath = getExecutablePath() + "geckodriver-" + getSystemArchitecture();
        if (getOperatingSystem().equals("windows")) {
            driverPath = driverPath + ".exe";
        }
        System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        return new FirefoxDriver(firefoxOptions);
    }

    private InternetExplorerDriver getInternetExplorerDriver() throws UnsupportedCommandException {
        String error = "Internet Explorer Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private EdgeDriver getEdgeDriver() throws UnsupportedCommandException {
        String error = "Microsoft Edge Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private SafariDriver getSafariDriver() throws UnsupportedCommandException {
        String error = "Apple Safari Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private String getExecutablePath() throws UnsupportedCommandException {
        String separator = System.getProperty("file.separator");
        String suiteHome = System.getProperty("user.dir");
        ArrayList<String> pathParts = new ArrayList<String>(Arrays.asList(suiteHome.split(separator)));
        pathParts.add("drivers");
        pathParts.add(getOperatingSystem());
        pathParts.add("");
        return String.join(separator, pathParts.toArray(new String[0]));
    }

    private String getOperatingSystem() throws UnsupportedCommandException {
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

    private String getSystemArchitecture() throws UnsupportedCommandException {
        String osArch = System.getProperty("os.arch");
        if (osArch.contains("64")) {
            return "64";
        }
        else if (osArch.contains("86")) {
            return "32";
        }
        else {
            throw new UnsupportedCommandException("System Architecture \'" + osArch + "\' is not supported");
        }
    }

}