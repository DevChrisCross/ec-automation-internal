package com.elavon.tasks.genericTasks;

import com.elavon.tasks.operateCustomer.ImpersonateAccount;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class Impersonate {

    public static Performable theUserProfile() {
        return Instrumented.instanceOf(ImpersonateAccount.class).withProperties();
    }
}
