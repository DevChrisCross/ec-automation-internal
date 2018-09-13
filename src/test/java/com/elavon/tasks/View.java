package com.elavon.tasks;

import net.serenitybdd.core.steps.Instrumented;

public class View {

    public static ViewProfile theProfileOf(String userId) {
        return Instrumented.instanceOf(ViewProfile.class).withProperties(userId);
    }
}
