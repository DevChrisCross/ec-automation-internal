package com.elavon.tasks.modifyUserProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.ViewUserProfilePage;
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

        todoList.add(ClickOn.the(ViewUserProfilePage.ACCOUNT_OPTIONS));
        todoList.add(Click.on(ViewUserProfilePage.DELETE_ACCOUNT_OPTION));
        todoList.add(ClickOn.the(isCompletely ?
                ViewUserProfilePage.DeleteModal.DELETE_BUTTON :
                ViewUserProfilePage.DeleteModal.CANCEL_BUTTON));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
