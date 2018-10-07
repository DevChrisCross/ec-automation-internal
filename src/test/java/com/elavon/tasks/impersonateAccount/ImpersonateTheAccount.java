package com.elavon.tasks.impersonateAccount;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.searchCustomer.ViewTheAccount;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ImpersonateTheAccount implements Task {

    private static String name = ViewTheAccount.getName();

    public static ImpersonateTheAccount ofTheUser() {
        return Instrumented.instanceOf(ImpersonateTheAccount.class).withProperties();
    }

    @Override
    @Step("{0} impersonates the user account #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.IMPERSONATE_BUTTON)
        );
    }
}
