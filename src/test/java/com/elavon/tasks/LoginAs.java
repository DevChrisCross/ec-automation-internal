package com.elavon.tasks;

import com.elavon.setup.UserType;
import net.serenitybdd.core.steps.Instrumented;

public class LoginAs {

    public static LoginUser anInternalUser() {
        return Instrumented.instanceOf(LoginUser.class)
                .withProperties(UserType.INTERNAL);
    }

    public static LoginUser anExternalUser() {
        return Instrumented.instanceOf(LoginUser.class)
                .withProperties(UserType.EXTERNAL);
    }
}
