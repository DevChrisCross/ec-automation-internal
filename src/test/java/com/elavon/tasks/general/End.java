package com.elavon.tasks.general;

import com.elavon.tasks.userProfile.EndUserImpersonation;
import net.serenitybdd.core.steps.Instrumented;

public class End {

    public static EndUserImpersonation theImpersonationOfTheUser() {
        return Instrumented.instanceOf(EndUserImpersonation.class).withProperties();
    }
}
