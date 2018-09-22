package com.elavon.tasks.genericTasks;

import com.elavon.tasks.modifyUserProfile.ResetPassword;
import net.serenitybdd.core.steps.Instrumented;

public class Reset {

    public static ResetPassword thePasswordOfTheUserAccount() {
        return Instrumented.instanceOf(ResetPassword.class).withProperties();
    }
}
