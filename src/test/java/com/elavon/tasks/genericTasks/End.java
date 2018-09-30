package com.elavon.tasks.genericTasks;

import com.elavon.tasks.operateCustomer.EndImpersonationAccount;
import net.serenitybdd.core.steps.Instrumented;

public class End {

    public static EndImpersonationAccount theImpersonationOfTheUser() {
        return Instrumented.instanceOf(EndImpersonationAccount.class).withProperties();
    }
}
