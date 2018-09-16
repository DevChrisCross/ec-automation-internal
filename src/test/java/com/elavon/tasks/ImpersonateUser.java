package com.elavon.tasks;

import com.elavon.ui.pages.CustomerProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ImpersonateUser implements Task {

    private String userId;

    public ImpersonateUser(String userId) {
        this.userId = userId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                View.theUserProfileOf(userId),
//                WaitUntilThe.targetIsLoaded(CustomerProfilePage.IMPERSONATE_BUTTON),
                Click.on(CustomerProfilePage.IMPERSONATE_BUTTON),
                WaitUntilThe.pageIsFullyLoaded()
//                WaitUntil.the(CustomerSearchPage.TOAST_MESSAGE, isVisible())
//                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds(),
//                WaitUntil.the(CustomerSearchPage.TOAST_MESSAGE, isNotCurrentlyVisible())
//                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds(),
//                WaitUntil.the(CustomerProfilePage.IMPERSONATED_DASHBOARD, isVisible())
//                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds()

        );
    }
}
