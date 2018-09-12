package com.elavon.ui;

import com.elavon.ui.pages.HomePage;
import com.elavon.ui.pages.LoginPage;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetResolver;
import net.thucydides.core.pages.PageObject;
import org.apache.tools.ant.taskdefs.Tar;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum Page {
    HOME("Home Page", "welcome",
            null, HomePage.class),
    LOGIN("Login Page", "login",
            ImmutableMap.of(Page.HOME, HomePage.LOGIN_BUTTON), LoginPage.class),
    CONTACT_US("Contact Us Page", "contactus",
            ImmutableMap.of(Page.HOME, HomePage.CONTACT_US_BUTTON), null),
    TERMS_OF_USE("Terms of Use Page", "termsOfUseEu",
            ImmutableMap.of(Page.HOME, HomePage.TERMS_OF_USE_LINK), null),
    COOKIES_POLICY("Cookies Policy Page", "cookiesPolicyEu",
            ImmutableMap.of(Page.HOME, HomePage.COOKIES_POLICY_LINK), null);

    private String description;
    private String url;
    private Map<Page, Target> buttons;
    private Class<? extends PageObject> pageObject;

    Page(String description, String url, Map<Page, Target> buttons, Class<? extends PageObject> pageObject) {
        this.description = description;
        this.url = url;
        this.buttons = buttons;
        this.pageObject = pageObject;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Map<Page, Target> getButtons() {
        return buttons;
    }

    public Class<? extends PageObject> getPageObject() {
        return pageObject;
    }
}
