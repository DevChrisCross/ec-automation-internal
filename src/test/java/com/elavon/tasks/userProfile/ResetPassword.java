package com.elavon.tasks.userProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.UserProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

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

        todoList.add(ClickOn.the(UserProfilePage.RESET_PASSWORD_BUTTON));
        todoList.add(ClickOn.the(isCompletely ?
                UserProfilePage.RESET_MODAL_SEND_BUTTON :
                UserProfilePage.RESET_MODAL_CANCEL_BUTTON));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
