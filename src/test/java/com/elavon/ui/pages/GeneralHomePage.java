package com.elavon.ui.pages;

import com.elavon.binder.Bindable;
import com.elavon.binder.Binder;
import com.elavon.helper.LocatorGenerator;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.Map;

public class GeneralHomePage extends PageObject {

    public static final Target LOGIN_BUTTON = Target
            .the("login button")
            .located(By.id("navbarSignIn"));
    public static final Target CONTACT_US_BUTTON = Target
            .the("contact us button")
            .located(By.id("navbarContactUs"));
    public static final Target COOKIES_DISCLAIMER_CLOSE_BUTTON = Target
            .the("cookies disclaimer close button")
            .located(By.xpath("/html/body/div[1]/md-content/div/footer[2]/div[1]/div[2]/button"));
    public static Map<Bindable, Map<?, ?>> bind = Binder.bindMapOf(GeneralHomePage.class);

    public static class Footer {

        private static LocatorGenerator footerLink = new LocatorGenerator("span.eu-footer-links:nth-child(@COUNTER)");

        public static final Target TERMS_OF_USE_LINK = Target
                .the("terms of use link")
                .located(By.cssSelector(footerLink.generate(2)));
        public static final Target COOKIES_POLICY_LINK = Target
                .the("cookies poilcy link")
                .located(By.cssSelector(footerLink.generate(3)));
    }
}