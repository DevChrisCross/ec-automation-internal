package com.elavon.tasks.createNewCustomer;

import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.CustomerAccount.AddNewCustomerPage;
import com.elavon.ui.pages.CustomerAccount.CloneCustomerPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class CloneAccount extends CreateAccount implements Task {

    public CloneAccount() {
        super();
    }

    @Override
    @Step("{0} creates the new user clones the user account #firstName@#lastName #status")
    public <T extends Actor> void performAs(T actor) {
        increaseUserCount();
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.CLONE_USER_BUTTON),
                provideDefaultInformation(),
                ClickOn.the(CloneCustomerPage.NEXT_BUTTON),
                SuccessOrFail(
                        new Performable[]{ClickOn.the(AddNewCustomerPage.Confirmation.CREATE_USER_BUTTON)},
                        new Performable[] {
                                ClickOn.the(AddNewCustomerPage.Confirmation.BACK_BUTTON),
                                ClickOn.the(AddNewCustomerPage.CANCEL_BUTTON)
                        })
        );
    }
}

