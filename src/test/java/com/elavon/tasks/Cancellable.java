package com.elavon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public abstract class Cancellable implements Task {

    protected boolean isCompletely = true;
    protected String status = isCompletely ? "" : "incompletely";

    protected Target SuccessOrFail(Target success, Target fail) {
        return isCompletely ? success : fail;
    }

    protected Performable SuccessOrFail(Performable[] success, Performable[] fail) {
        return isCompletely ?
                new CombinedTasks(success) :
                new CombinedTasks(fail);

    }

    public Performable incompletely() {
        isCompletely = false;
        return this;
    }

    private class CombinedTasks implements Task {

        private Performable[] performables;

        public CombinedTasks(Performable[] performables) {
            this.performables = performables;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(performables);
        }
    }
}
