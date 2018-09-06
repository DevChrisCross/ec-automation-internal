package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public final static Target LOGIN_BUTTON = Target.the("login button").located(By.id("loginSignIn"));
    public final static Target USERNAME_FIELD = Target.the("username field").located(By.id("loginUsername"));
    public final static Target PASSWORD_FIELD = Target.the("password field").located(By.id("loginPassword"));

}
