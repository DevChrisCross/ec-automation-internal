package com.elavon.tasks.accessApplication;

import com.elavon.constants.UserType;
import com.elavon.setup.CredentialKey;
import com.elavon.tasks.waitToLoad.WaitUntilThe;
import com.elavon.ui.pages.AccountLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.Optional;

import static com.elavon.setup.Application.CONFIG;

public class LoginUser implements Task {

    private final String username;
    private final String password;

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
    @Step("{0} logins using the user #username")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(AccountLoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(AccountLoginPage.PASSWORD_FIELD).thenHit(Keys.ENTER),
                WaitUntilThe.pageIsFullyLoaded()
        );
    }
}
