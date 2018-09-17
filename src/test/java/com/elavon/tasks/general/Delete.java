package com.elavon.tasks.general;

import com.elavon.tasks.userProfile.DeleteUserAccount;
import net.serenitybdd.core.steps.Instrumented;

public class Delete {

    public static DeleteUserAccount theUserAccount() {
        return Instrumented.instanceOf(DeleteUserAccount.class).withProperties();
    }
}
