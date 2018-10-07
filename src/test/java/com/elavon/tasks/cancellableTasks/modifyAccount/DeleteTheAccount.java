package com.elavon.tasks.cancellableTasks.modifyAccount;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.cancellableTasks.Cancellable;
import com.elavon.tasks.searchCustomer.ViewTheAccount;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class DeleteTheAccount extends Cancellable implements Task {

    private static String name = ViewTheAccount.getName();

    public static DeleteTheAccount ofTheUser() {
        return Instrumented.instanceOf(DeleteTheAccount.class).withProperties();
    }

    @Override
    @Step("{0} deletes the user account #name #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.ACCOUNT_OPTIONS),
                Click.on(ViewCustomerPage.DELETE_ACCOUNT_OPTION),
                ProceedOrCancel(ViewCustomerPage.DELETE_MODAL_BUTTON)
        );
    }
}
