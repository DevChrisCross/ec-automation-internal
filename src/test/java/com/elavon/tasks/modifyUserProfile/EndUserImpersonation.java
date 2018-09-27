package com.elavon.tasks.modifyUserProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.searchCustomer.ViewCustomerAccount;
import com.elavon.ui.pages.CustomerAccount.ImpersonateCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class EndUserImpersonation implements Task {

    private static String name = ViewCustomerAccount.getName();

    @Override
    @Step("{0} ends the impersonation of the user account #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ImpersonateCustomerPage.IMPERSONATE_END_BUTTON)
        );
    }
}
