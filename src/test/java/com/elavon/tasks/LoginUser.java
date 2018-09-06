package com.elavon.tasks;

import com.elavon.setup.CredentialKey;
import com.elavon.setup.UserType;
import com.elavon.ui.pages.HomePage;
import com.elavon.ui.pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.ResourceBundle;

public class LoginUser implements Task {

    boolean isFromHome;
    private String username;
    private String password;
    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");

    public LoginUser(UserType user) {
        String baseConfigName = "credentials."
                + CONFIG.getString("environment.type").toLowerCase() + "."
                + user.toString().toLowerCase();

        try {
            this.username = CredentialKey.retrieve(baseConfigName + ".username");
            this.password = CredentialKey.retrieve(baseConfigName + ".password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Step("Login using the user #username")
    public <T extends Actor> void performAs(T actor) {
        Performable navigateToLoginPage = isFromHome ? Click.on(HomePage.LOGIN_BUTTON) : OpenTheApplication.onTheLoginPage();
        actor.attemptsTo(
                navigateToLoginPage,
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD).thenHit(Keys.ENTER)
        );
    }
}
