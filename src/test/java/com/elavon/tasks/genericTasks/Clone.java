package com.elavon.tasks.genericTasks;

import com.elavon.tasks.createNewUser.CloneUser;
import net.serenitybdd.core.steps.Instrumented;

public class Clone {

    public static CloneUser theUser() {
        return Instrumented.instanceOf(CloneUser.class).withProperties();
    }
}
