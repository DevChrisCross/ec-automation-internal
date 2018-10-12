package com.elavon.setup;

import com.elavon.binder.PageBind;
import io.github.bonigarcia.wdm.DriverManagerType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Application {

    public static final String API;
    public static final int MAXIMUM_TIMEOUT;
    public static final PropertiesConfiguration CONFIG;

    public static Actor user;
    public static WebDriver browser;
    public static Cast cast;

    static {
        Optional<PropertiesConfiguration> config = Optional.empty();

        try {
            config = Optional.of(new PropertiesConfiguration("config.properties"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        CONFIG = config.orElse(new PropertiesConfiguration());
        API = CONFIG.getString("environment.url.restapi");
        MAXIMUM_TIMEOUT = CONFIG.getInt("environment.timeout.maximum");
        PageBind.loadBinders();
    }

    public static WebDriver generateBrowser() {
        String driver = CONFIG.getString("environment.driver");
        browser = (new Driver(
                DriverManagerType.valueOf(driver.toUpperCase()),
                CONFIG.getString("environment.binary." + driver))).getBrowser();
        if (CONFIG.getBoolean("environment.timeout.enabled")) {
            browser.manage().timeouts()
                    .implicitlyWait(CONFIG.getInt("environment.timeout.element"), TimeUnit.SECONDS)
                    .setScriptTimeout(CONFIG.getInt("environment.timeout.script"), TimeUnit.SECONDS)
                    .pageLoadTimeout(CONFIG.getInt("environment.timeout.page"), TimeUnit.SECONDS);
        }
        return browser;
    }

    public static Actor generateUser() {
        generateBrowser();
        user = (new Actor(CONFIG.getString("user.name")))
                .can(BrowseTheWeb.with(browser))
                .can(CallAnApi.at(API));
        return user;
    }

    public static Cast generateCast() {
        cast = Cast.whereEveryoneCan(
                BrowseTheWeb.with(generateBrowser()),
                CallAnApi.at(API));
        return cast;
    }
}
