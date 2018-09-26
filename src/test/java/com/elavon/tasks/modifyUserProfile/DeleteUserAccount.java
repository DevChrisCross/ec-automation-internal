package com.elavon.tasks.modifyUserProfile;

import com.elavon.constants.Cancellable;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.List;

public class DeleteUserAccount extends Cancellable implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();

        todoList.add(ClickOn.the(ViewCustomerPage.ACCOUNT_OPTIONS));
        todoList.add(Click.on(ViewCustomerPage.DELETE_ACCOUNT_OPTION));
        todoList.add(ClickOn.the(SuccessOrFail(
                ViewCustomerPage.DeleteModal.DELETE_BUTTON,
                ViewCustomerPage.DeleteModal.CANCEL_BUTTON)));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }
}
