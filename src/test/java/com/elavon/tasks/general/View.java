package com.elavon.tasks.general;

import com.elavon.tasks.customerSearch.ViewUserProfile;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class View {

    public static Performable theUserProfileOf(String userId) {
        return Instrumented.instanceOf(ViewUserProfile.class).withProperties(userId);
    }
}
