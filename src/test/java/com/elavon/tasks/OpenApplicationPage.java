package com.elavon.tasks;

import com.elavon.setup.Application;
import com.elavon.setup.EnvironmentLocale;
import com.elavon.setup.EnvironmentType;
import com.elavon.ui.Page;
import com.elavon.ui.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

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
        if (isFromHome) {
            todoList.add(Click.on(HomePage.COOKIES_DISCLAIMER_CLOSE_BUTTON));
            todoList.add(Click.on(page.getButtons().get(Page.HOME)));
        }

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
