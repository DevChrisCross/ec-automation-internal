package com.elavon.tasks.open;

import com.elavon.setup.EnvironmentLocale;
import com.elavon.setup.EnvironmentType;
import com.elavon.tasks.WaitUntilThe;
import com.elavon.ui.Page;
import com.elavon.ui.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
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
        this.url = baseUrl + locale.toString() + "/" + page.getUrl();
    }

    @Step("Opens the application in the #page page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();

        todoList.add(Open.url(url));
//        todoList.add(WaitUntilThe.pageIsFullyLoaded());
        if (isFromHome) {
            if (page.equals(Page.COOKIES_POLICY) || page.equals(Page.TERMS_OF_USE)) {
                todoList.add(Click.on(HomePage.COOKIES_DISCLAIMER_CLOSE_BUTTON));
            }
            Target targetButton = page.getButtons().get(Page.HOME);
//            todoList.add(WaitUntilThe.targetIsLoaded(targetButton));
            todoList.add(Click.on(targetButton));
        }
        todoList.add(WaitUntilThe.pageIsFullyLoaded());

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
