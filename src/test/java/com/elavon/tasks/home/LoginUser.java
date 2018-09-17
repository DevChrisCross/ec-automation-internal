package com.elavon.tasks.home;

import com.elavon.setup.CredentialKey;
import com.elavon.setup.constants.UserType;
import com.elavon.tasks.wait.WaitUntilThe;
import com.elavon.ui.pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
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
        List<Performable> todoList = new ArrayList<>();

        todoList.add(Enter.theValue(username).into(LoginPage.USERNAME_FIELD));
        todoList.add(Enter.theValue(password).into(LoginPage.PASSWORD_FIELD).thenHit(Keys.ENTER));
        todoList.add(WaitUntilThe.pageIsFullyLoaded());

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
