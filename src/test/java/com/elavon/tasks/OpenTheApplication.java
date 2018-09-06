package com.elavon.tasks;

import com.elavon.setup.EnvironmentLocale;
import com.elavon.setup.EnvironmentType;
import com.elavon.setup.PageUrl;
import com.elavon.ui.pages.HomePage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import java.util.Optional;
import java.util.ResourceBundle;

public class OpenTheApplication implements Task{

    private boolean isFromHome;
    private String baseUrl;
    private String pageUrl;
    private EnvironmentType envType;
    private EnvironmentLocale localeType;
    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");

    @Override
    @Step("Opens the application at #baseUrl")
    public <T extends Actor> void performAs(T actor) {
        if (isFromHome) {
            Target navigationButton = retrieveButtonFor(pageUrl);
            pageUrl = PageUrl.HOME;
            constructUrl();

            actor.attemptsTo(
                    Open.url(baseUrl),
                    Click.on(navigationButton)
            );
        } else {
            actor.attemptsTo(Open.url(baseUrl));
        }
    }

    public OpenTheApplication(String pageUrl) {

        String env = CONFIG.getString("environment.type");
        envType = EnvironmentType.valueOf(env.toUpperCase());

        String locale = CONFIG.getString("environment.locale");
        localeType = EnvironmentLocale.valueOf(locale);

        isFromHome = false;
        this.pageUrl = pageUrl;
        constructUrl();
    }

    public static OpenTheApplication onTheHomePage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties(PageUrl.HOME);
    }

    public static OpenTheApplication onTheLoginPage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties(PageUrl.LOGIN);
    }

    public static OpenTheApplication onTheContactUsPage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties(PageUrl.CONTACT_US);
    }

    public static OpenTheApplication onTheCookiesPolicyPage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties(PageUrl.PRIVACY_POLICY);
    }

    public static OpenTheApplication onTheTermsOfUsePage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties(PageUrl.TERMS_OF_USE);
    }

    public OpenTheApplication fromTheHomePage() {
        isFromHome = true;
        return this;
    }

    public OpenTheApplication withTheEnvironmentOf(EnvironmentType envType) {
        this.envType = envType;
        constructUrl();
        return this;
    }

    public OpenTheApplication withTheLocaleOf(EnvironmentLocale locale) {
        this.localeType = locale;
        constructUrl();
        return this;
    }

    private void constructUrl() {
        String qaUrl = CONFIG.getString("environment.url.qa");
        String uatUrl = CONFIG.getString("environment.url.uat");
        String prodUrl = CONFIG.getString("environment.url.prod");
        Optional<String> baseUrl = Optional.ofNullable(this.baseUrl);

        if (envType.equals(EnvironmentType.QA))   { baseUrl = Optional.of(qaUrl); }
        if (envType.equals(EnvironmentType.UAT))  { baseUrl = Optional.of(uatUrl); }
        if (envType.equals(EnvironmentType.PROD)) { baseUrl = Optional.of(prodUrl); }

        this.baseUrl = baseUrl.orElse(qaUrl) + localeType.toString() + "/" + pageUrl;
    }

    private Target retrieveButtonFor(String pageUrl) {
        Optional<Target> target = Optional.empty();

        if (pageUrl.equals(PageUrl.LOGIN))          { target = Optional.of(HomePage.LOGIN_BUTTON); }
        if (pageUrl.equals(PageUrl.CONTACT_US))     { target = Optional.of(HomePage.CONTACT_US_BUTTON); }
        if (pageUrl.equals(PageUrl.PRIVACY_POLICY)) { target = Optional.of(HomePage.COOKIES_POLICY_LINK); }
        if (pageUrl.equals(PageUrl.TERMS_OF_USE))   { target = Optional.of(HomePage.TERMS_OF_USE_LINK); }

        return target.orElse(HomePage.LOGIN_BUTTON);
    }
}
