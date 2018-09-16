package com.elavon.tasks;

import com.elavon.ui.pages.CustomerProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class EndUserImpersonation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
//                WaitUntilThe.targetIsLoaded(CustomerProfilePage.IMPERSONATE_BUTTON),
                Click.on(CustomerProfilePage.IMPERSONATE_END_BUTTON),
                WaitUntilThe.pageIsFullyLoaded()
//                WaitUntil.the(CustomerSearchPage.TOAST_MESSAGE, isVisible())
//                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds(),
//                WaitUntil.the(CustomerSearchPage.TOAST_MESSAGE, isNotCurrentlyVisible())
//                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds(),
//                WaitUntil.the(CustomerProfilePage.ACCOUNT_DETAILS_CARD, isVisible())
//                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds()
        );
    }
}
