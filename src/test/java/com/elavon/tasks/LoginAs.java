package com.elavon.tasks;

import com.elavon.setup.UserType;
import net.serenitybdd.core.steps.Instrumented;

public class LoginAs extends LoginUser{

    public LoginAs(UserType user) {
        super(user);
    }

    public LoginUser fromTheHomePage() {
        isFromHome = true;
        return this;
    }

    public static LoginAs anInternalUser() {
        return Instrumented.instanceOf(LoginAs.class)
                .withProperties(UserType.INTERNAL);
    }

    public static LoginAs anExternalUser() {
        return Instrumented.instanceOf(LoginAs.class)
                .withProperties(UserType.EXTERNAL);
    }

}
