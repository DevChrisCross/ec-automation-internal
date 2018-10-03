package com.elavon.tasks.genericTasks;

import com.elavon.constants.UserProfile;
import com.elavon.tasks.operateCustomer.UpdateProfile;
import net.serenitybdd.core.steps.Instrumented;

public class Update {

    public static UpdateProfile theCustomerProfile(UserProfile userProfile) {
        return Instrumented.instanceOf(UpdateProfile.class).withProperties(userProfile);
    }

}
