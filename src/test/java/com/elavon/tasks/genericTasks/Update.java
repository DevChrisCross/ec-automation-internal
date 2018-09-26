package com.elavon.tasks.genericTasks;

import com.elavon.constants.UserLocationRule;
import com.elavon.constants.UserProfile;
import com.elavon.tasks.modifyUserProfile.UpdateAssignedLocations;
import com.elavon.tasks.modifyUserProfile.UpdateCustomerProfile;
import net.serenitybdd.core.steps.Instrumented;

public class Update {

    public static UpdateCustomerProfile theCustomerProfile(UserProfile userProfile) {
        return Instrumented.instanceOf(UpdateCustomerProfile.class).withProperties(userProfile);
    }

    public static UpdateAssignedLocations theAssignedLocationsWithTheRuleOf(UserLocationRule locationRule) {
        return Instrumented.instanceOf(UpdateAssignedLocations.class).withProperties(locationRule);
    }
}
