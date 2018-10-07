package com.elavon.tasks.cancellableTasks.createNewCustomer;

import com.elavon.interactions.ClickOn;
import com.elavon.model.UserAccount;
import com.elavon.tasks.cancellableTasks.Cancellable;
import com.elavon.tasks.cancellableTasks.updateLocations.AddNewLocation;
import com.elavon.ui.pages.CustomerAccount.AddNewCustomerPage;
import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.IHomePageNavigation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class AddTheNewUser extends Cancellable implements Task {

    private final UserAccount userAccount;

    public AddTheNewUser(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public static AccountBuilder ofUser() {
        return new AccountBuilder(AddTheNewUser.class);
    }

    @Override
    @Step("{0} creates a new user account #status")
    public <T extends Actor> void performAs(T actor) {
        UserAccount.increaseUserCount();
        actor.attemptsTo(
                ClickOn.the(IHomePageNavigation.CUSTOMER_SEARCH_TAB),
                ClickOn.the(CustomerSearchPage.ADD_CUSTOMERS_LINK),
                FillUpCustomerInformation.withDetailsOf(userAccount),
                ClickOn.the(AddNewCustomerPage.NEXT_BUTTON),
                AddNewLocation.withTheValueOf(userAccount.getLocations().get(0)),
                ClickOn.the(AddNewCustomerPage.NEXT_BUTTON),
                ProceedOrCancel(
                        new Performable[]{ClickOn.the(AddNewCustomerPage.Confirmation.CREATE_USER_BUTTON)},
                        new Performable[]{
                                ClickOn.the(AddNewCustomerPage.Confirmation.BACK_BUTTON),
                                ClickOn.the(AddNewCustomerPage.CANCEL_BUTTON),
                                ClickOn.the(AddNewCustomerPage.CANCEL_BUTTON)
                        })
        );
    }
}
