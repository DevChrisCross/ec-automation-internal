package com.elavon.tasks.impersonateAccount;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.searchCustomer.ViewTheAccount;
import com.elavon.ui.pages.CustomerAccount.ViewImpersonationPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class EndTheImpersonation implements Task {

    private static String name = ViewTheAccount.getName();

    public static EndTheImpersonation ofTheUser() {
        return Instrumented.instanceOf(EndTheImpersonation.class).withProperties();
    }

    @Override
    @Step("{0} ends the impersonation of the user account #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewImpersonationPage.IMPERSONATE_END_BUTTON)
        );
    }
}
