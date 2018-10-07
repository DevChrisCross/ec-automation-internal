package com.elavon.tasks.genericTasks;

import com.elavon.tasks.createNewCustomer.AddAccount;
import net.serenitybdd.core.steps.Instrumented;

public class Add {

    public static AddAccount theNewUser() {
        return Instrumented.instanceOf(AddAccount.class).withProperties();
    }

}
