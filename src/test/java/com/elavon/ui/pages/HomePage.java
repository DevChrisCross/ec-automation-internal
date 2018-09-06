package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    public final static Target LOGIN_BUTTON =
            Target.the("login button").located(By.id("navbarSignIn"));
    public final static Target CONTACT_US_BUTTON =
            Target.the("contact us button").located(By.id("navbarContactUs"));
    public final static Target TERMS_OF_USE_LINK =
            Target.the("terms of use link").located(By.cssSelector("span.eu-footer-links:nth-child(2)"));
    public final static Target COOKIES_POLICY_LINK =
            Target.the("cookies poilcy link").located(By.cssSelector("span.eu-footer-links:nth-child(3)"));
}
