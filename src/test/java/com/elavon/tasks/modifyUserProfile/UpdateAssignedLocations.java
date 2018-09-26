package com.elavon.tasks.modifyUserProfile;

import com.elavon.constants.Cancellable;
import com.elavon.constants.UserLocationRule;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.waitToLoad.WaitUntilThe;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class UpdateAssignedLocations extends Cancellable implements Task {

    private UserLocationRule locationRule;
    private String value;
    private String clg;

    public UpdateAssignedLocations(UserLocationRule locationRule) {
        this.locationRule = locationRule;
    }

    @Override
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

    public UpdateAssignedLocations withTheValueOf(String value) {
        this.value = value;
        return this;
    }

    public UpdateAssignedLocations fromTheClientGroup(String clg) {
        this.clg = clg;
        return this;
    }
}
