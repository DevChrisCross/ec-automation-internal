package com.elavon.interactions;

import com.elavon.tasks.wait.WaitUntilThe;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class ClickOn implements Interaction {

    private Target target;

    public ClickOn(Target target) { this.target = target; }

    public static ClickOn the(Target target) {
        return Instrumented.instanceOf(ClickOn.class).withProperties(target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntilThe.targetIsLoaded(target),
                Scroll.to(target),
                Click.on(target),
                WaitUntilThe.pageIsFullyLoaded()
        );
    }
}
