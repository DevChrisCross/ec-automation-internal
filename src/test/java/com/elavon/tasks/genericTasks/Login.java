package com.elavon.tasks.genericTasks;

import com.elavon.constants.UserType;
import com.elavon.tasks.accessApplication.LoginUser;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class Login {

    public static Performable as(UserType userType) {
        return Instrumented.instanceOf(LoginUser.class).withProperties(userType);
    }
}