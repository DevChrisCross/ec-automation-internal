package com.elavon.tasks.wait;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.targets.Target;

public class WaitUntilThe {

    public static WaitPageLoad pageIsFullyLoaded() {
        return Instrumented.instanceOf(WaitPageLoad.class).withProperties();
    }

    public static WaitElementLoad targetIsLoaded(Target target) {
        return Instrumented.instanceOf(WaitElementLoad.class).withProperties(target);
    }


}
