package com.elavon.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class InternetExplorerBrowser implements Browsable {

    @Override
    public RemoteWebDriver setup(File binaryFile) {
        WebDriverManager.iedriver().setup();

        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability("ignoreZoomSetting", true);
        options.setCapability("ie.ensureCleanSession", true);

        return new InternetExplorerDriver(options);
    }
}
