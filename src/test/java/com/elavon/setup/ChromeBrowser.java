package com.elavon.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class ChromeBrowser implements Browsable {

    @Override
    public RemoteWebDriver setup(File binaryFile) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setCapability("applicationCacheEnabled", false);
        if (binaryFile.canExecute()) { options.setBinary(binaryFile); }

        return new ChromeDriver(options);
    }
}
