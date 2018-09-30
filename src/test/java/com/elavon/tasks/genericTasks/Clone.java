package com.elavon.tasks.genericTasks;

import com.elavon.tasks.createNewCustomer.CloneAccount;
import net.serenitybdd.core.steps.Instrumented;

public class Clone {

    public static CloneAccount theUser() {
        return Instrumented.instanceOf(CloneAccount.class).withProperties();
    }
}
