package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.id("loginSignIn"));
    public static final Target USERNAME_FIELD = Target.the("username field").located(By.id("loginUsername"));
    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.id("loginPassword"));

}
