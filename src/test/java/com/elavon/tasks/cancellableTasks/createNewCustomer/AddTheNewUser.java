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
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTheNewUser extends Cancellable implements Task {

    private final UserAccount userAccount;
    private String userToClone;

    public AddTheNewUser(UserAccount userAccount) {
        this.userAccount = userAccount;
        this.userToClone = "";
    }

    public AddTheNewUser byCloningTheUserOf(String userToClone) {
        this.userToClone = userToClone;
        return this;
    }

    public static AccountBuilder<AddTheNewUser> ofUser() {
        return new AccountBuilder<>(AddTheNewUser.class);
    }

    @Override
    @Step("{0} creates a new user account #status")
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();
        todoList.addAll(Arrays.asList(
                ClickOn.the(IHomePageNavigation.CUSTOMER_SEARCH_TAB),
                ClickOn.the(CustomerSearchPage.ADD_CUSTOMERS_LINK),
                FillUpCustomerInformation.withDetailsOf(userAccount)
        ));

        if (userToClone.isEmpty()) {
            todoList.addAll(Arrays.asList(
                    ClickOn.the(AddNewCustomerPage.NEXT_BUTTON),
                    AddNewLocation.withTheValueOf(userAccount.getLocations()),
                    ClickOn.the(AddNewCustomerPage.NEXT_BUTTON)
            ));
        } else {
            todoList.addAll(Arrays.asList(
                    Click.on(AddNewCustomerPage.CLONE_EXISTING_BUTTON),
                    Enter.theValue(userToClone).into(AddNewCustomerPage.CloneModal.USERNAME_FIELD),
                    ClickOn.the(AddNewCustomerPage.CloneModal.SEARCH_BUTTON),
                    ClickOn.the(AddNewCustomerPage.CloneModal.NEXT_BUTTON)
            ));
        }

        todoList.add(ProceedOrCancel(
                new Performable[]{ClickOn.the(AddNewCustomerPage.Confirmation.CREATE_USER_BUTTON)},
                new Performable[]{
                        ClickOn.the(AddNewCustomerPage.Confirmation.BACK_BUTTON),
                        ClickOn.the(AddNewCustomerPage.CANCEL_BUTTON),
                        ClickOn.the(AddNewCustomerPage.CANCEL_BUTTON)
                }));

        actor.attemptsTo(todoList.toArray(new Performable[]{}));
        if (isCompletely) { UserAccount.increaseUserCount(); }
    }
}
