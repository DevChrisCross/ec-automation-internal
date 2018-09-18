package com.elavon.tasks.general;

import com.elavon.constants.UserType;
import com.elavon.tasks.home.LoginUser;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class Login {

    public static Performable as(UserType userType) {
        return Instrumented.instanceOf(LoginUser.class).withProperties(userType);
    }
}
