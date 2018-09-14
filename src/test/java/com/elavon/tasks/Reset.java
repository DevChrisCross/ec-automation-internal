package com.elavon.tasks;

import net.serenitybdd.core.steps.Instrumented;

public class Reset {

    public static ResetPassword thePasswordOfTheUserAccount() {
        return Instrumented.instanceOf(ResetPassword.class).withProperties();
    }
}
