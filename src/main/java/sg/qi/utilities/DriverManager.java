package sg.qi.utilities;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import java.util.ArrayList;
import java.util.Arrays;

public class DriverManager {

    public static WebDriver createDriver() throws UnsupportedCommandException {
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
            return driver;
        }
        catch (NullPointerException e) {
            String error = "Environment Variable \'browser\' contains an invalid value: " + browser;
            throw new UnsupportedCommandException(error);
        }
    }

    private static ChromeDriver getChromeDriver() throws UnsupportedCommandException {
        String driverPath = getExecutablePath() + "chromedriver-" + getSystemArchitecture();
        if (getOperatingSystem().equals("windows")) {
            driverPath = driverPath + ".exe";
        }
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver(new ChromeOptions());
    }

    private static FirefoxDriver getFirefoxDriver() throws UnsupportedCommandException {
        String driverPath = getExecutablePath() + "geckodriver-" + getSystemArchitecture();
        if (getOperatingSystem().equals("windows")) {
            driverPath = driverPath + ".exe";
        }
        System.setProperty("webdriver.gecko.driver", driverPath);
        return new FirefoxDriver(new FirefoxOptions());
    }

    private static InternetExplorerDriver getInternetExplorerDriver() throws UnsupportedCommandException {
        String error = "Internet Explorer Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private static EdgeDriver getEdgeDriver() throws UnsupportedCommandException {
        String error = "Microsoft Edge Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private static SafariDriver getSafariDriver() throws UnsupportedCommandException {
        String error = "Apple Safari Browser is not supported";
        throw new UnsupportedCommandException(error);
    }

    private static String getExecutablePath() throws UnsupportedCommandException {
        String separator = System.getProperty("file.separator");
        String suiteHome = System.getProperty("user.dir");
        ArrayList<String> pathParts = new ArrayList<String>(Arrays.asList(suiteHome.split(separator)));
        pathParts.add("drivers");
        pathParts.add(getOperatingSystem());
        pathParts.add("");
        return String.join(separator, pathParts.toArray(new String[0]));
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

    private static String getSystemArchitecture() throws UnsupportedCommandException {
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