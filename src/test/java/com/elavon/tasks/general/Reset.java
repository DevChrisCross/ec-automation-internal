package com.elavon.tasks.general;

import com.elavon.tasks.userProfile.ResetPassword;
import net.serenitybdd.core.steps.Instrumented;

public class Reset {

    public static ResetPassword thePasswordOfTheUserAccount() {
        return Instrumented.instanceOf(ResetPassword.class).withProperties();
    }
}
