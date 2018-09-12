package com.elavon.tasks.login;

import com.elavon.setup.UserType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class Login {

    public static Performable as(UserType userType) {
        return Instrumented.instanceOf(LoginUser.class).withProperties(userType);
    }
}
