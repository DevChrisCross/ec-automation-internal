package com.elavon.ui.pages;

import com.elavon.binder.Bindable;
import com.elavon.binder.Binder;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.Map;

public class HomePage extends PageObject {

    public static Map<Bindable, Map<?, ?>> bind = Binder.bindMapOf(HomePage.class);

    public static final Target LOGIN_BUTTON =
            Target.the("login button").located(By.id("navbarSignIn"));
    public static final Target CONTACT_US_BUTTON =
            Target.the("contact us button").located(By.id("navbarContactUs"));
    public static final Target TERMS_OF_USE_LINK =
            Target.the("terms of use link").located(By.cssSelector("span.eu-footer-links:nth-child(2)"));
    public static final Target COOKIES_POLICY_LINK =
            Target.the("cookies poilcy link").located(By.cssSelector("span.eu-footer-links:nth-child(3)"));
    public static final Target COOKIES_DISCLAIMER_CLOSE_BUTTON =
            Target.the("cookies disclaimer close button")
                    .located(By.xpath("/html/body/div[1]/md-content/div/footer[2]/div[1]/div[2]/button"));
}
