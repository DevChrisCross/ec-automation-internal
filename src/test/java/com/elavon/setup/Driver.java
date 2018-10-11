package com.elavon.setup;

import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class Driver extends RemoteWebDriver {

    private WebDriver browser;

    public Driver(DriverManagerType driver) { this(driver, ""); }

    public Driver(DriverManagerType driver, String pathToBinary) {
        File binaryFile = new File(pathToBinary);
        Browsable browser;
        switch (driver) {
            case IEXPLORER:
                browser = new InternetExplorerBrowser();
                break;
            case FIREFOX:
                browser = new FirefoxBrowser();
                break;
            case CHROME:
                browser = new ChromeBrowser();
                break;
            default:
                throw new UnsupportedOperationException();
        }
        this.browser = browser.setup(binaryFile);
        this.browser.manage().window().maximize();
        this.browser.manage().deleteAllCookies();
    }

    public WebDriver getBrowser() {
        return browser;
    }
}
