package com.elavon.tasks.cancellableTasks;

import com.elavon.interactions.ClickOn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public abstract class Cancellable implements Task {

    public static final Target ACTION_BUTTON = Target
            .the("Action button")
            .locatedBy("//md-card-actions/button[{0}]");

    protected boolean isCompletely = true;
    protected String status = "";

    protected Performable ProceedOrCancel() {
        return ProceedOrCancel(ACTION_BUTTON);
    }

    protected Performable ProceedOrCancel(Target action) {
        return ClickOn.the(isCompletely ?
                action.of("2").called("update button") :
                action.of("1").called("cancel button"));
    }

    protected Performable ProceedOrCancel(Performable[] success, Performable[] fail) {
        return isCompletely ?
                new CombinedTasks(success) :
                new CombinedTasks(fail);
    }

    public Performable incompletely() {
        isCompletely = false;
        status = "incompletely";
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
