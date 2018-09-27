package com.elavon.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public abstract class Cancellable implements Task {

    private boolean isCompletely = true;
    protected String status = isCompletely ? "" : "incompletely";

    protected Target SuccessOrFail(Target success, Target fail) {
        return isCompletely ? success : fail;
    }

    public Performable incompletely() {
        isCompletely = false;
        return this;
    }
}
