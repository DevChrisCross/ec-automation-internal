package com.elavon.tasks.modifyUserProfile;

import com.elavon.constants.Cancellable;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

public class ResetPassword extends Cancellable implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();

        todoList.add(ClickOn.the(ViewCustomerPage.RESET_PASSWORD_BUTTON));
        todoList.add(ClickOn.the(SuccessOrFail(
                ViewCustomerPage.ResetModal.SEND_BUTTON,
                ViewCustomerPage.ResetModal.CANCEL_BUTTON))
        );

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
