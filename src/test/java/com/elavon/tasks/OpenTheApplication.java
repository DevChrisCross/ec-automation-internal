package com.elavon.tasks;

import com.elavon.setup.EnvironmentLocale;
import com.elavon.setup.EnvironmentType;
import com.elavon.setup.PageUrl;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import java.util.ResourceBundle;

public class OpenTheApplication implements Task{

    private String baseUrl;
    private String pageUrl;
    private EnvironmentType envType;
    private EnvironmentLocale localeType;
    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");

    @Override
    @Step("Opens the application at #baseUrl")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(baseUrl)
        );
    }

    public OpenTheApplication(String pageUrl) {

        String env = CONFIG.getString("environment.type");
        envType = EnvironmentType.valueOf(env.toUpperCase());

        String locale = CONFIG.getString("environment.locale");
        localeType = EnvironmentLocale.valueOf(locale);

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
        baseUrl = "";
        switch (envType) {
            case QA:
                baseUrl = CONFIG.getString("environment.url.qa");
                break;
            case UAT:
                baseUrl = CONFIG.getString("environment.url.uat");
                break;
            case PROD:
                baseUrl = CONFIG.getString("environment.url.prod");
                break;
        }
        baseUrl += localeType.toString() + "/" + pageUrl;
    }
}
