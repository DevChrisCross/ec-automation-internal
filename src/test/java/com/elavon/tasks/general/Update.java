package com.elavon.tasks.general;

import com.elavon.constants.UserProfile;
import com.elavon.tasks.userProfile.UpdateCustomerProfile;
import net.serenitybdd.core.steps.Instrumented;

public class Update {

    public static UpdateCustomerProfile theCustomerProfile(UserProfile userProfile) {
        return Instrumented.instanceOf(UpdateCustomerProfile.class).withProperties(userProfile);
    }
}
