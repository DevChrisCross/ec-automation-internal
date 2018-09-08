package com.elavon.tasks.login;

import com.elavon.setup.Application;
import com.elavon.setup.CredentialKey;
import com.elavon.setup.UserType;
import com.elavon.tasks.OpenTheApplication;
import com.elavon.ui.PageUrl;
import com.elavon.ui.pages.HomePage;
import com.elavon.ui.pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

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
        Deque<Performable> todoList = new ArrayDeque<>();

        if (currentUrl.endsWith(PageUrl.HOME)) {
            todoList.add(Click.on(HomePage.LOGIN_BUTTON));
        }
        if (!currentUrl.endsWith(PageUrl.LOGIN)) {
            todoList.add(OpenTheApplication.onTheLoginPage());
        }

        todoList.add(Enter.theValue(username).into(LoginPage.USERNAME_FIELD));
        todoList.add(Enter.theValue(password).into(LoginPage.PASSWORD_FIELD).thenHit(Keys.ENTER));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
