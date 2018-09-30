package com.elavon.tasks.operateCustomer;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.Cancellable;
import com.elavon.tasks.searchCustomer.ViewAccount;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class DeleteAccount extends Cancellable implements Task {

    private static String name = ViewAccount.getName();

    @Override
    @Step("{0} deletes the user account #name #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.ACCOUNT_OPTIONS),
                Click.on(ViewCustomerPage.DELETE_ACCOUNT_OPTION),
                ClickOn.the(SuccessOrFail(
                        ViewCustomerPage.DeleteModal.DELETE_BUTTON,
                        ViewCustomerPage.DeleteModal.CANCEL_BUTTON))
        );
    }
}
