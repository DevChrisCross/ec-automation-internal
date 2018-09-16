package com.elavon.tasks;

import com.elavon.ui.pages.CustomerProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.List;

public class DeleteUserAccount implements Task {

    private boolean isCompletely;

    public DeleteUserAccount() {
        isCompletely = true;
    }

    public Performable incompletely() {
        isCompletely = false;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();

//        todoList.add(WaitUntilThe.targetIsLoaded(CustomerProfilePage.ACCOUNT_OPTIONS));
        todoList.add(Click.on(CustomerProfilePage.ACCOUNT_OPTIONS));
        todoList.add(Click.on(CustomerProfilePage.DELETE_ACCOUNT_OPTION));
        todoList.add(Click.on(isCompletely ?
                CustomerProfilePage.DELETE_MODAL_DELETE_BUTTON :
                CustomerProfilePage.DELETE_MODAL_CANCEL_BUTTON));
        todoList.add(WaitUntilThe.pageIsFullyLoaded());

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
