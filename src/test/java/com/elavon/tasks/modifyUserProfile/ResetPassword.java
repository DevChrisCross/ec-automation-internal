package com.elavon.tasks.modifyUserProfile;

import com.elavon.constants.Cancellable;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.searchCustomer.ViewCustomerAccount;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ResetPassword extends Cancellable implements Task {

    private static String name = ViewCustomerAccount.getName();

    @Override
    @Step("{0} resets the password of user account #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.RESET_PASSWORD_BUTTON),
                ClickOn.the(SuccessOrFail(
                        ViewCustomerPage.ResetModal.SEND_BUTTON,
                        ViewCustomerPage.ResetModal.CANCEL_BUTTON))
        );
    }
}
