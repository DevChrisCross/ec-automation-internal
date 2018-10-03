package com.elavon.tasks.genericTasks;

import com.elavon.tasks.operateCustomer.AddLocations;
import com.elavon.tasks.operateCustomer.RemoveLocations;
import net.serenitybdd.core.steps.Instrumented;

public class UpdateUserLocations {

    public static AddLocations byAddingTheLocation() {
        return Instrumented.instanceOf(AddLocations.class).withProperties();
    }

    public static RemoveLocations byRemovingTheLocation() {
        return Instrumented.instanceOf(RemoveLocations.class).withProperties();
    }
}
