package com.elavon.tasks.operateCustomer;

import com.elavon.constants.UserLocationRule;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.Cancellable;
import com.elavon.tasks.searchCustomer.ViewAccount;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class AddLocations extends Cancellable implements Task {

    private static String name = ViewAccount.getName();
    private UserLocationRule rule;
    private String value;
    private String clg;

    public AddLocations() {
        rule = UserLocationRule.MID;
    }

    @Override
    @Step("{0} adds a location of #rule-#clg-#value to the user account #name #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.EDIT_LOCATIONS_BUTTON),
                FillUpCustomerLocations.withTheValueOf(rule, clg, value),
                ClickOn.the(SuccessOrFail(
                        EditLocationsPage.UPDATE_BUTTON,
                        EditLocationsPage.CANCEL_BUTTON))
        );
    }

    public AddLocations withTheRuleOf(UserLocationRule rule) {
        this.rule = rule;
        return this;
    }

    public AddLocations withTheValueOf(String value) {
        this.value = value;
        return this;
    }

    public AddLocations fromTheClientGroup(String clg) {
        this.clg = clg;
        return this;
    }
}
