package com.elavon.setup;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.ResourceBundle;

public class Driver {

    private WebDriver browser;
    private MutableCapabilities options;

    private static final ResourceBundle driverConfig = ResourceBundle.getBundle("webdrivermanager");
    private static final EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();

    public Driver() {
        this(env.getProperty("driver"));
    }

    public Driver(String driver) {
        this(DriverManagerType.valueOf(driver.toUpperCase()));
    }

    public Driver(DriverManagerType driver) {
        WebDriverManager.config().setTargetPath(driverConfig.getString("wdm.targetPath"));
        switch (driver) {
            case IEXPLORER:
                WebDriverManager.iedriver().setup();

                options = new InternetExplorerOptions();
                options.setCapability("ignoreZoomSetting", true);
                options.setCapability("ie.ensureCleanSession", true);

                browser = new InternetExplorerDriver((InternetExplorerOptions) options);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();

                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.cache.disk.enable", false);
                profile.setPreference("browser.cache.memory.enable", false);
                profile.setPreference("browser.cache.offline.enable", false);
                profile.setPreference("network.http.use-cache", false);

                options = new FirefoxOptions();
                options.setCapability(FirefoxDriver.PROFILE, profile);
                options.setCapability("acceptInsecureCerts", true);

                browser = new FirefoxDriver((FirefoxOptions) options);
                break;

            case CHROME:
                WebDriverManager.chromedriver().setup();

                options = new ChromeOptions();
                options.setCapability("applicationCacheEnabled", false);

                browser = new ChromeDriver((ChromeOptions) options);
                break;

            default:
                throw new UnsupportedOperationException();
        }

        browser.manage().window().maximize();
        browser.manage().deleteAllCookies();
    }

    public WebDriver getBrowser() {
        return browser;
    }

    public MutableCapabilities getOptions() {
        return options;
    }
}
