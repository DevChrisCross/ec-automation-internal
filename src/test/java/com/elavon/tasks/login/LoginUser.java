package com.elavon.tasks.login;

import com.elavon.setup.Application;
import com.elavon.setup.CredentialKey;
import com.elavon.setup.UserType;
import com.elavon.tasks.open.Open;
import com.elavon.ui.Page;
import com.elavon.ui.pages.HomePage;
import com.elavon.ui.pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.*;

import static com.elavon.setup.Application.CONFIG;

public class LoginUser implements Task {

    private String username;
    private String password;

    public LoginUser(UserType user) {
        String baseConfigName = "credentials."
                + CONFIG.getString("environment.type").toLowerCase() + "."
                + user.toString().toLowerCase();

        Optional<String> username = Optional.empty();
        Optional<String> password = Optional.empty();

        try {
            username = Optional.of(CredentialKey.retrieve(baseConfigName + ".username"));
            password = Optional.of(CredentialKey.retrieve(baseConfigName + ".password"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.username = username.orElse(CONFIG.getString("credentials.default.username"));
            this.password = password.orElse(CONFIG.getString("credentials.default.password"));
        }
    }

    @Override
    @Step("Login using the user #username")
    public <T extends Actor> void performAs(T actor) {
        String currentUrl = Application.BROWSER.getCurrentUrl();
        List<Performable> todoList = new ArrayList<>();

        if (currentUrl.endsWith(Page.HOME.getUrl())) {
            todoList.add(Click.on(HomePage.LOGIN_BUTTON));
        } else {
            todoList.add(Open.theApplication().onThe(Page.LOGIN));
        }

        todoList.add(Enter.theValue(username).into(LoginPage.USERNAME_FIELD));
        todoList.add(Enter.theValue(password).into(LoginPage.PASSWORD_FIELD).thenHit(Keys.ENTER));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
