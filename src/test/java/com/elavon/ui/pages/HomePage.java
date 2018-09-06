package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    public final static Target LOGIN_BUTTON = Target.the("login button").located(By.id("navbarSignIn"));
}
