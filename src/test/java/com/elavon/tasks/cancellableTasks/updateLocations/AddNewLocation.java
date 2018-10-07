package com.elavon.tasks.cancellableTasks.updateLocations;

import com.elavon.model.Location;
import com.elavon.tasks.waitToLoad.WaitUntilThe;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class AddNewLocation implements Task {

    private Location location;

    public AddNewLocation(Location location) {
        this.location = location;
    }

    public static AddNewLocation withTheValueOf(Location location) {
        return new AddNewLocation(location);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(EditLocationsPage.Location.RULE_CLOSE_BUTTON),
                Click.on(EditLocationsPage.Location.RULE_FIELD),
                JavaScriptClick.on(EditLocationsPage.bind.getDefaultItem(location.getRule())),
                Enter.theValue(location.getClg()).into(EditLocationsPage.Location.CLG_GROUP_FIELD),
                Enter.theValue(location.getValue()).into(EditLocationsPage.Location.VALUE_FIELD),
                WaitUntilThe.targetIsLoaded(EditLocationsPage.Location.VALUE_FIRST_OPTION),
                JavaScriptClick.on(EditLocationsPage.Location.VALUE_FIRST_OPTION)
        );
    }
}
