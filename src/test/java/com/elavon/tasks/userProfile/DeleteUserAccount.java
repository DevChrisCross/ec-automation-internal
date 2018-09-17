package com.elavon.tasks.userProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.UserProfilePage;
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

        todoList.add(ClickOn.the(UserProfilePage.ACCOUNT_OPTIONS));
        todoList.add(Click.on(UserProfilePage.DELETE_ACCOUNT_OPTION));
        todoList.add(ClickOn.the(isCompletely ?
                UserProfilePage.DELETE_MODAL_DELETE_BUTTON :
                UserProfilePage.DELETE_MODAL_CANCEL_BUTTON));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
