package com.elavon.tasks.createNewCustomer;

import com.elavon.constants.UserLocationRule;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.operateCustomer.AddLocations;
import com.elavon.ui.pages.CustomerAccount.AddCustomerPage;
import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.InternalHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class AddAccount extends CreateAccount implements Task {

    private UserLocationRule rule;
    private String clg;
    private String value;

    public AddAccount() {
        super();
        rule = UserLocationRule.MID;
    }

    @Override
    @Step("{0} creates a new user account #status")
    public <T extends Actor> void performAs(T actor) {
        increaseUserCount();
        actor.attemptsTo(
                ClickOn.the(InternalHomePage.CUSTOMER_SEARCH_TAB),
                ClickOn.the(CustomerSearchPage.ADD_CUSTOMERS_LINK),
                provideDefaultInformation(),
                ClickOn.the(AddCustomerPage.NEXT_BUTTON),
                AddLocations.withTheValueOf(rule, clg, value),
                ClickOn.the(AddCustomerPage.NEXT_BUTTON),
                SuccessOrFail(
                        new Performable[]{ClickOn.the(AddCustomerPage.Confirmation.CREATE_USER_BUTTON)},
                        new Performable[]{
                                ClickOn.the(AddCustomerPage.Confirmation.BACK_BUTTON),
                                ClickOn.the(AddCustomerPage.CANCEL_BUTTON),
                                ClickOn.the(AddCustomerPage.CANCEL_BUTTON)
                        })
        );
    }

    public AddAccount withTheRuleOf(UserLocationRule rule) {
        this.rule = rule;
        return this;
    }

    public AddAccount withTheValueOf(String value) {
        this.value = value;
        return this;
    }

    public AddAccount fromTheClientGroup(String clg) {
        this.clg = clg;
        return this;
    }
}
