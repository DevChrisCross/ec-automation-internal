package com.elavon.constants;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public abstract class Cancellable implements Task {

    private boolean isCompletely = true;

    protected Target SuccessOrFail(Target success, Target fail) {
        return isCompletely ? success : fail;
    }

    public Performable incompletely() {
        isCompletely = false;
        return this;
    }
}
