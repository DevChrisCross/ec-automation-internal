package com.elavon.tasks.cancellableTasks.modifyAccount;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.cancellableTasks.Cancellable;
import com.elavon.tasks.searchCustomer.ViewTheAccount;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ResetThePassword extends Cancellable implements Task {

    private static String name = ViewTheAccount.getName();

    public static ResetThePassword ofTheUser() {
        return Instrumented.instanceOf(ResetThePassword.class).withProperties();
    }

    @Override
    @Step("{0} resets the password of user account #name #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.RESET_PASSWORD_BUTTON),
                ProceedOrCancel(ViewCustomerPage.RESET_MODAL_BUTTON)
        );
    }
}
