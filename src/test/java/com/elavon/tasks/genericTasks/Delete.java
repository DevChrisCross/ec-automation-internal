package com.elavon.tasks.genericTasks;

import com.elavon.tasks.operateCustomer.DeleteAccount;
import net.serenitybdd.core.steps.Instrumented;

public class Delete {

    public static DeleteAccount theUserAccount() {
        return Instrumented.instanceOf(DeleteAccount.class).withProperties();
    }
}
