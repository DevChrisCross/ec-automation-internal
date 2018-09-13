package com.elavon.setup;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Application {

    public static final int MAXIMUM_TIMEOUT = 10;
    public static final Actor USER;
    public static final WebDriver BROWSER;
    public static final PropertiesConfiguration CONFIG;

    static {
        Optional<PropertiesConfiguration> config = Optional.empty();

        try {
            config = Optional.of(new PropertiesConfiguration("config.properties"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        CONFIG = config.orElse(new PropertiesConfiguration());
        BROWSER = (new Driver(CONFIG.getString("environment.driver"))).getBrowser();
        USER = (new Actor(CONFIG.getString("user.name")))
                .can(BrowseTheWeb.with(BROWSER))
                .can(CallAnApi.at(CONFIG.getString("environment.url.restapi")));

        if (CONFIG.getBoolean("environment.timeout.enabled")) {
            BROWSER.manage().timeouts()
                    .implicitlyWait(CONFIG.getInt("environment.timeout.element"), TimeUnit.SECONDS)
                    .setScriptTimeout(CONFIG.getInt("environment.timeout.script"), TimeUnit.SECONDS)
                    .pageLoadTimeout(CONFIG.getInt("environment.timeout.page"), TimeUnit.SECONDS);
        }
    }

    public Actor can(List<Ability> abilities) {
        abilities.forEach(USER::can);
        return USER;
    }
}
