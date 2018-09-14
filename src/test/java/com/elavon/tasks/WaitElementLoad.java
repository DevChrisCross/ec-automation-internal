package com.elavon.tasks;

import com.elavon.setup.Application;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitElementLoad implements Task {

    private Target target;

    public WaitElementLoad(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds());
    }
}
