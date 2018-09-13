package com.elavon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class View {

    public static Performable theProfileOf(String userId) {
        return Instrumented.instanceOf(ViewProfile.class).withProperties(userId);
    }
}
