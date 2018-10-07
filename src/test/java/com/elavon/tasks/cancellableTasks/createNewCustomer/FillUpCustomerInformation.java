package com.elavon.tasks.cancellableTasks.createNewCustomer;

import com.elavon.model.UserAccount;
import com.elavon.ui.pages.CustomerAccount.AddNewCustomerPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class FillUpCustomerInformation implements Task {

    private UserAccount account;

    public FillUpCustomerInformation(UserAccount account) {
        this.account = account;
    }

    public static FillUpCustomerInformation withDetailsOf(UserAccount account) {
        return Instrumented.instanceOf(FillUpCustomerInformation.class).withProperties(account);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target languageToSelect = AddNewCustomerPage.bind.getDefaultItem(account.getLanguage());
        Target roleToSelect = AddNewCustomerPage.bind.getDefaultItem(account.getRole());

        actor.attemptsTo(
                Enter.theValue(account.getFirstName()).into(AddNewCustomerPage.FIRST_NAME_FIELD),
                Enter.theValue(account.getLastName()).into(AddNewCustomerPage.LAST_NAME_FIELD),
                Enter.theValue(account.getEmail()).into(AddNewCustomerPage.EMAIL_FIELD),
                Click.on(AddNewCustomerPage.LANGUAGE_DROPDOWN),
                Click.on(languageToSelect),
                Click.on(roleToSelect)
        );

    }
}
