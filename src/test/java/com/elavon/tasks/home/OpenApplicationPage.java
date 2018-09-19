package com.elavon.tasks.home;

import com.elavon.constants.Bind;
import com.elavon.constants.EnvironmentLocale;
import com.elavon.constants.EnvironmentType;
import com.elavon.constants.Page;
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

import static com.elavon.setup.Application.CONFIG;

public class OpenApplicationPage implements Task {

    private boolean isFromHome;
    private String url;
    private Page page;

    public OpenApplicationPage(Page page, EnvironmentType env, EnvironmentLocale locale, boolean isFromHome) {
        String baseUrl = CONFIG.getString("environment.url." + env.toString().toLowerCase());
        this.page = page;
        this.isFromHome = isFromHome;

        page = isFromHome ? Page.HOME : page;
        this.url = baseUrl + locale.toString() + "/" + Bind.pageMap.get(HomePage.class).get(page).get("url");
    }

    @Step("Opens the application in the #page page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();

        todoList.add(Open.url(url));
        if (isFromHome) {
            if (page.equals(Page.COOKIES_POLICY) || page.equals(Page.TERMS_OF_USE)) {
                todoList.add(ClickOn.the(HomePage.COOKIES_DISCLAIMER_CLOSE_BUTTON));
            }
            Target targetButton = (Target) Bind.pageMap.get(HomePage.class).get(page).get("target");
            todoList.add(ClickOn.the(targetButton));
        }

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
