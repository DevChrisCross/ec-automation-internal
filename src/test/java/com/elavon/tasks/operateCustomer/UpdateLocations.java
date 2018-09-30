package com.elavon.tasks.operateCustomer;

import com.elavon.constants.UserLocationRule;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.Cancellable;
import com.elavon.tasks.searchCustomer.ViewAccount;
import com.elavon.tasks.waitToLoad.WaitUntilThe;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.thucydides.core.annotations.Step;

public class UpdateLocations extends Cancellable implements Task {

    private static String name = ViewAccount.getName();
    private final UserLocationRule locationRule;
    private String value;
    private String clg;

    public UpdateLocations(UserLocationRule locationRule) {
        this.locationRule = locationRule;
    }

    @Override
    @Step("{0} adds a location of #locationRule-#clg-#value to the user account #name #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.EDIT_LOCATIONS_BUTTON),
                Click.on(EditLocationsPage.Location.RULE_CLOSE_BUTTON),
                Click.on(EditLocationsPage.Location.RULE_FIELD),
                JavaScriptClick.on(EditLocationsPage.bind.getDefaultItem(locationRule)),
                Enter.theValue(clg).into(EditLocationsPage.Location.CLG_GROUP_FIELD),
                Enter.theValue(value).into(EditLocationsPage.Location.VALUE_FIELD),
                WaitUntilThe.targetIsLoaded(EditLocationsPage.Location.VALUE_FIRST_OPTION),
                JavaScriptClick.on(EditLocationsPage.Location.VALUE_FIRST_OPTION),
                ClickOn.the(SuccessOrFail(
                        EditLocationsPage.UPDATE_BUTTON,
                        EditLocationsPage.CANCEL_BUTTON))
        );
    }

    public UpdateLocations withTheValueOf(String value) {
        this.value = value;
        return this;
    }

    public UpdateLocations fromTheClientGroup(String clg) {
        this.clg = clg;
        return this;
    }
}