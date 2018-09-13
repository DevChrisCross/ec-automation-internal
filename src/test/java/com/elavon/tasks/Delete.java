package com.elavon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class Delete {

    public static DeleteUserAccount theUserAccount() {
        return Instrumented.instanceOf(DeleteUserAccount.class).withProperties();
    }
}
