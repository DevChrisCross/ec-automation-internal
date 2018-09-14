package com.elavon.tasks;

import com.elavon.setup.Application;
import com.elavon.ui.pages.CustomerProfilePage;
import com.elavon.ui.pages.CustomerSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.Wait;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ImpersonateUser implements Task {

    private String userId;

    public ImpersonateUser(String userId) {
        this.userId = userId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                View.theUserProfileOf(userId),
                Click.on(CustomerProfilePage.IMPERSONATE_BUTTON),
                WaitUntil.the(CustomerSearchPage.TOAST_MESSAGE, isVisible())
                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds(),
                WaitUntil.the(CustomerSearchPage.TOAST_MESSAGE, isNotCurrentlyVisible())
                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds(),
                WaitUntil.the(CustomerProfilePage.IMPERSONATED_DASHBOARD, isVisible())
                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds()

        );
    }
}
