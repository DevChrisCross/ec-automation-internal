package com.elavon.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class FirefoxBrowser implements Browsable {

    @Override
    public RemoteWebDriver setup(File binaryFile) {
        WebDriverManager.firefoxdriver().setup();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(FirefoxDriver.PROFILE, profile);
        options.setCapability("acceptInsecureCerts", true);

        if (binaryFile.canExecute()) {
            FirefoxBinary ffBinary = new FirefoxBinary(binaryFile);
            options.setCapability(FirefoxDriver.BINARY, ffBinary);
        }

        return new FirefoxDriver(options);
    }
}
