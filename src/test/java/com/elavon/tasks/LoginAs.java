package com.elavon.tasks;

public class LoginAs {

    public static LoginAs anInternalUser() {
        return new LoginAs();
    }

    public static LoginAs anExternalUser() {
        return new LoginAs();
    }

}
