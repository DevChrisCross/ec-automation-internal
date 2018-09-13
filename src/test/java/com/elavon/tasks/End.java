package com.elavon.tasks;

import net.serenitybdd.core.steps.Instrumented;

public class End {

    public static EndUserImpersonation theImpersonationOfTheUser() {
        return Instrumented.instanceOf(EndUserImpersonation.class).withProperties();
    }
}
