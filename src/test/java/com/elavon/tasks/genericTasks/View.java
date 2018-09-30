package com.elavon.tasks.genericTasks;

import com.elavon.tasks.searchCustomer.ViewAccount;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class View {

    public static Performable theUserProfileOf(String userId) {
        return Instrumented.instanceOf(ViewAccount.class).withProperties(userId);
    }
}
