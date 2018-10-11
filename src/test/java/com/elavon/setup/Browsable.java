package com.elavon.setup;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public interface Browsable {

    RemoteWebDriver setup(File binaryFile);
}
