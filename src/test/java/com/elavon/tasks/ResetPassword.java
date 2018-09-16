package com.elavon.tasks;

import com.elavon.ui.pages.CustomerProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.List;

public class ResetPassword implements Task {

    private boolean isCompletely;

    public ResetPassword() {
        isCompletely = true;
    }

    public Performable incompletely() {
        isCompletely = false;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();

//        todoList.add(WaitUntilThe.targetIsLoaded(CustomerProfilePage.RESET_PASSWORD_BUTTON));
        todoList.add(Click.on(CustomerProfilePage.RESET_PASSWORD_BUTTON));
        todoList.add(Click.on(isCompletely ?
                CustomerProfilePage.RESET_MODAL_SEND_BUTTON :
                CustomerProfilePage.RESET_MODAL_CANCEL_BUTTON));
        todoList.add(WaitUntilThe.pageIsFullyLoaded());

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
