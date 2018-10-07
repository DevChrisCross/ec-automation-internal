package com.elavon.tasks.operateCustomer;

import com.elavon.constants.user.UserLocationRule;
import com.elavon.tasks.waitToLoad.WaitUntilThe;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class FillUpCustomerLocations implements Task {

    private UserLocationRule locationRule;
    private String value;
    private String clg;

    public FillUpCustomerLocations(UserLocationRule locationRule, String clg, String value) {
        this.locationRule = locationRule;
        this.clg = clg;
        this.value = value;
    }

    public static FillUpCustomerLocations withTheValueOf(UserLocationRule locationRule, String clg, String value) {
        return Instrumented.instanceOf(FillUpCustomerLocations.class).withProperties(locationRule, clg, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(EditLocationsPage.Location.RULE_CLOSE_BUTTON),
                Click.on(EditLocationsPage.Location.RULE_FIELD),
                JavaScriptClick.on(EditLocationsPage.bind.getDefaultItem(locationRule)),
                Enter.theValue(clg).into(EditLocationsPage.Location.CLG_GROUP_FIELD),
                Enter.theValue(value).into(EditLocationsPage.Location.VALUE_FIELD),
                WaitUntilThe.targetIsLoaded(EditLocationsPage.Location.VALUE_FIRST_OPTION),
                JavaScriptClick.on(EditLocationsPage.Location.VALUE_FIRST_OPTION)
        );
    }
}
