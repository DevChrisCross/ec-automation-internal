package com.elavon.setup;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    public static WebDriver browser = (new DriverSetup()).getBrowser();
    public static String defaultName = "Application user";
    public static List<Ability> defaultAbilities = Collections.singletonList(BrowseTheWeb.with(browser));

    public static Actor unnamed() {
        return User.named(defaultName);
    }

    public static Actor named(String name) {
        return User.preparedWith(name, new ArrayList<>());
    }

    public static Actor withAbilityOf(List<Ability> abilities) {
        return User.preparedWith(defaultName, abilities);
    }

    public static Actor preparedWith(String name, List<Ability> abilities) {
        Actor actor = Actor.named(name);
        abilities.addAll(defaultAbilities);
        for (Ability doSomething : abilities) {
            actor.can(doSomething);
        }
        return actor;
    }
}
