package com.elavon.tasks.operateCustomer;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.searchCustomer.ViewAccount;
import com.elavon.ui.pages.CustomerAccount.ViewImpersonationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class EndImpersonationAccount implements Task {

    private static String name = ViewAccount.getName();

    @Override
    @Step("{0} ends the impersonation of the user account #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewImpersonationPage.IMPERSONATE_END_BUTTON)
        );
    }
}
