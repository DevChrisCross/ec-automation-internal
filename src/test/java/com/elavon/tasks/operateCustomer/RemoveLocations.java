package com.elavon.tasks.operateCustomer;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.Cancellable;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class RemoveLocations extends Cancellable implements Task {

    private String value;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.EDIT_LOCATIONS_BUTTON),
                RemoveCustomerLocations.withTheValueOf(value),
                ClickOn.the(SuccessOrFail(
                        EditLocationsPage.UPDATE_BUTTON,
                        EditLocationsPage.CANCEL_BUTTON))
        );
    }

    public RemoveLocations withTheValueOf(String value) {
        this.value = value;
        return this;
    }
}
