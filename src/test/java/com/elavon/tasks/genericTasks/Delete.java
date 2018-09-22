package com.elavon.tasks.genericTasks;

import com.elavon.tasks.modifyUserProfile.DeleteUserAccount;
import net.serenitybdd.core.steps.Instrumented;

public class Delete {

    public static DeleteUserAccount theUserAccount() {
        return Instrumented.instanceOf(DeleteUserAccount.class).withProperties();
    }
}
