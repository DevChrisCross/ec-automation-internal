package com.elavon.tasks.cancellableTasks.updateLocations;

import com.elavon.constants.Operation;
import com.elavon.interactions.ClickOn;
import com.elavon.model.Location;
import com.elavon.tasks.cancellableTasks.Cancellable;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class UpdateLocations extends Cancellable implements Task {

    private Operation operation;
    private Location location;

    public UpdateLocations(Operation operation, Location location) {
        this.operation = operation;
        this.location = location;
    }

    @Override
    @Step("{0} updates a location of #rule-#clg-#value to the user account #name #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.EDIT_LOCATIONS_BUTTON),
                operation.equals(Operation.ADDING) ?
                        AddNewLocation.withTheValueOf(location) :
                        Click.on(EditLocationsPage.Location.REMOVE_LOCATION_BUTTON.of(location.getValue())),
                ProceedOrCancel(EditLocationsPage.ACTION_BUTTON)
        );
    }
}
