package com.elavon.tasks.home;

import com.elavon.binder.Bindable;
import com.elavon.binder.Binder;
import com.elavon.constants.EnvironmentLocale;
import com.elavon.constants.EnvironmentType;
import com.elavon.constants.HomeNav;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.elavon.setup.Application.CONFIG;

public class OpenApplicationPage implements Task {

    private boolean isFromHome;
    private String url;
    private static Map<Bindable, Map<?, ?>> bind = Binder.mapOf(HomePage.class);
    private HomeNav homeNav;

    public OpenApplicationPage(HomeNav homeNav, EnvironmentType env, EnvironmentLocale locale, boolean isFromHome) {
        String baseUrl = CONFIG.getString("environment.url." + env.toString().toLowerCase());
        this.homeNav = homeNav;
        this.isFromHome = isFromHome;

        homeNav = isFromHome ? HomeNav.HOME : homeNav;
        this.url = baseUrl + locale.toString() + "/" + bind.get(homeNav).get("url");
        // TODO: Cleanup code for binders
    }

    @Step("Opens the application in the #homeNav homeNav")
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();
        Map<Bindable, Map<?, ?>> bind = Binder.mapOf(HomePage.class);

        todoList.add(Open.url(url));
        if (isFromHome) {
            if (homeNav.equals(HomeNav.COOKIES_POLICY) || homeNav.equals(HomeNav.TERMS_OF_USE)) {
                todoList.add(ClickOn.the(HomePage.COOKIES_DISCLAIMER_CLOSE_BUTTON));
            }

            Target targetButton = (Target) bind.get(homeNav).get("target");
            todoList.add(ClickOn.the(targetButton));
        }

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
