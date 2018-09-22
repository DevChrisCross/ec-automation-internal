package com.elavon.tasks.genericTasks;

import com.elavon.constants.UserProfile;
import com.elavon.tasks.modifyUserProfile.UpdateCustomerProfile;
import net.serenitybdd.core.steps.Instrumented;

public class Update {

    public static UpdateCustomerProfile theCustomerProfile(UserProfile userProfile) {
        return Instrumented.instanceOf(UpdateCustomerProfile.class).withProperties(userProfile);
    }
}
