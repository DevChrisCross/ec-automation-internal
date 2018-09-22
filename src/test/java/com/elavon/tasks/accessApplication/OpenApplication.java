package com.elavon.tasks.accessApplication;

import com.elavon.constants.EnvironmentLocale;
import com.elavon.constants.EnvironmentType;
import com.elavon.constants.HomeNavigation;
import com.elavon.constants.PageUrl;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.GeneralHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.elavon.setup.Application.CONFIG;

public class OpenApplication implements Task {

    private String url;
    private HomeNavigation homeNavigation;

    public OpenApplication(HomeNavigation homeNavigation, EnvironmentType env, EnvironmentLocale locale) {
        String baseUrl = CONFIG.getString("environment.url." + env.toString().toLowerCase());
        this.homeNavigation = homeNavigation;
        this.url = baseUrl + locale.toString() + "/" + PageUrl.HOME.getUrl();
    }

    @Step("Opens the application in the #homeNavigation homeNavigation")
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();

        todoList.add(Open.url(url));
        if (homeNavigation.equals(HomeNavigation.COOKIES_POLICY) ||
                homeNavigation.equals(HomeNavigation.TERMS_OF_USE)) {
            todoList.add(ClickOn.the(GeneralHomePage.COOKIES_DISCLAIMER_CLOSE_BUTTON));
        }

        Target targetButton = GeneralHomePage.bind.get(homeNavigation).get("target");
        todoList.add(ClickOn.the(targetButton));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
