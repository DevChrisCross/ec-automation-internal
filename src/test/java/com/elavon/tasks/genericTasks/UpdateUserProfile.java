package com.elavon.tasks.genericTasks;

import com.elavon.constants.user.UserProfile;
import com.elavon.tasks.operateCustomer.UpdateProfile;
import net.serenitybdd.core.steps.Instrumented;

public class UpdateUserProfile {

    public static UpdateProfile byChangingTheFieldOf(UserProfile userProfile) {
        return Instrumented.instanceOf(UpdateProfile.class).withProperties(userProfile);
    }
}
