package com.elavon.ui.pages;

import com.elavon.binder.DataBind;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class GeneralHomePage extends PageObject {

    public static DataBind<String, Target> bind;

    public static final Target LOGIN_BUTTON = Target
            .the("login button")
            .located(By.id("navbarSignIn"));
    public static final Target CONTACT_US_BUTTON = Target
            .the("contact us button")
            .located(By.id("navbarContactUs"));
    public static final Target COOKIES_DISCLAIMER_CLOSE_BUTTON = Target
            .the("cookies disclaimer close button")
            .located(By.xpath("//button[@ng-click='vm.closeDisclaimer()']"));

    public static class Footer {

        public static final Target FOOTER_LINK = Target
                .the("footer link")
                .locatedBy("//span[@ng-click=\"vm.footerRedirect('{0}')\"]");
        public static final Target TERMS_OF_USE_LINK = FOOTER_LINK.of("terms").called("terms of use link");
        public static final Target COOKIES_POLICY_LINK = FOOTER_LINK.of("cookies").called("cookies poilcy link");
    }
}
