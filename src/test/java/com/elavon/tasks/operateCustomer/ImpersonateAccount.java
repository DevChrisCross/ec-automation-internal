package com.elavon.tasks.operateCustomer;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.searchCustomer.ViewAccount;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ImpersonateAccount implements Task {

    private static String name = ViewAccount.getName();

    @Override
    @Step("{0} impersonates the user account #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.IMPERSONATE_BUTTON)
        );
    }
}
