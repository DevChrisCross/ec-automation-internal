package com.elavon.tasks.genericTasks;

import com.elavon.tasks.modifyUserProfile.EndUserImpersonation;
import net.serenitybdd.core.steps.Instrumented;

public class End {

    public static EndUserImpersonation theImpersonationOfTheUser() {
        return Instrumented.instanceOf(EndUserImpersonation.class).withProperties();
    }
}
