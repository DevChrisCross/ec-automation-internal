package com.elavon.tasks.cancellableTasks.createNewCustomer;

import com.elavon.interactions.ClickOn;
import com.elavon.model.UserAccount;
import com.elavon.tasks.cancellableTasks.Cancellable;
import com.elavon.ui.pages.CustomerAccount.AddNewCustomerPage;
import com.elavon.ui.pages.CustomerAccount.CloneCustomerPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class CloneTheAccount extends Cancellable implements Task {

    private final UserAccount userAccount;

    public CloneTheAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public static AccountBuilder<CloneTheAccount> ofUser() {
        return new AccountBuilder(CloneTheAccount.class);
    }

    @Override
    @Step("{0} creates the new user clones the user account #firstName@#lastName #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.CLONE_USER_BUTTON),
                FillUpCustomerInformation.withDetailsOf(userAccount),
                ClickOn.the(CloneCustomerPage.NEXT_BUTTON),
                ProceedOrCancel(
                        new Performable[]{ClickOn.the(AddNewCustomerPage.Confirmation.CREATE_USER_BUTTON)},
                        new Performable[] {
                                ClickOn.the(AddNewCustomerPage.Confirmation.BACK_BUTTON),
                                ClickOn.the(AddNewCustomerPage.CANCEL_BUTTON)
                        })
        );
        if (isCompletely) { UserAccount.increaseUserCount(); }
    }
}

