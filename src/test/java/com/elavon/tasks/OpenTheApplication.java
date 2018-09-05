package com.elavon.tasks;

import com.elavon.setup.EnvironmentLocale;
import com.elavon.setup.EnvironmentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import java.util.ResourceBundle;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheApplication implements Task{

    String baseUrl;
    ResourceBundle config;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(baseUrl)
        );
    }

    public static Task onTheHomePage() {
        return instrumented(OpenTheApplication.class);
    }

    public static Task onTheEnvironmentOf(EnvironmentType envType) {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties(envType);
    }

    public static Task onTheLocaleOf(EnvironmentLocale locale) {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties(locale);
    }

    public static Task withEnvironmentAndLocaleOf(EnvironmentType envType, EnvironmentLocale locale) {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties(envType, locale);
    }

    public static Task onTheLoginPage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties("login");
    }

    public static Task onTheContactUsPage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties("contactus");
    }

    public static Task onTheCookiesPolicyPage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties("cookiePolicyEu");
    }

    public static Task onTheTermsOfUsePage() {
        return Instrumented.instanceOf(OpenTheApplication.class)
                .withProperties("termsOfUseEu");
    }

    public OpenTheApplication(String pageUrl) {
        this();
        baseUrl += pageUrl;
    }

    public OpenTheApplication() { this(EnvironmentType.NONE, EnvironmentLocale.NONE); }

    public OpenTheApplication(EnvironmentType envType) { this(envType, EnvironmentLocale.NONE); }

    public OpenTheApplication(EnvironmentLocale locale) { this(EnvironmentType.NONE, locale); }

    public OpenTheApplication(EnvironmentType envType, EnvironmentLocale localeType) {

        config = ResourceBundle.getBundle("config");
        if (envType.equals(EnvironmentType.NONE)) {
            String env = config.getString("environment.type");
            envType = EnvironmentType.valueOf(env.toUpperCase());
        }

        if (localeType.equals(EnvironmentLocale.NONE)) {
            String locale = config.getString("environment.locale");
            localeType = EnvironmentLocale.valueOf(locale);
        }

        switch (envType) {
            case QA:
                baseUrl = config.getString("environment.qa.url");
                break;
            case UAT:
                baseUrl = config.getString("environment.uat.url");
                break;
            case PROD:
                baseUrl = config.getString("environment.prod.url");
                break;
        }
        baseUrl += localeType.toString() + "/";
    }
}
