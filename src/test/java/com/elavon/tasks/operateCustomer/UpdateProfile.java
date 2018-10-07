package com.elavon.tasks.operateCustomer;

import com.elavon.constants.user.UserProfile;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.Cancellable;
import com.elavon.tasks.searchCustomer.ViewAccount;
import com.elavon.ui.pages.CustomerAccount.EditCustomerProfilePage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class UpdateProfile extends Cancellable implements Task {

    private static String name = ViewAccount.getName();
    private final UserProfile userProfile;
    private Enum value;

    public UpdateProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    @Step("{0} updates the #userProfile to #value of the user account #name #status")
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();
        Target fieldToEdit = EditCustomerProfilePage.bind.getDefaultItem(userProfile);
        Target valueToSelect = EditCustomerProfilePage.bind.getDefaultItem(value);

        todoList.add(ClickOn.the(ViewCustomerPage.EDIT_PROFILE_BUTTON));
        if (userProfile.equals(UserProfile.FIRST_NAME)
                || userProfile.equals(UserProfile.LAST_NAME)
                || userProfile.equals(UserProfile.EMAIL)) {
            todoList.add(Enter.theValue(value.toString()).into(fieldToEdit));
        } else {
            if (userProfile.equals(UserProfile.LANGUAGE)) {
                todoList.add(Click.on(fieldToEdit));
            }
            todoList.add(Click.on(valueToSelect));
        }
        todoList.add(ClickOn.the(SuccessOrFail(
                EditCustomerProfilePage.UPDATE_BUTTON,
                EditCustomerProfilePage.CANCEL_BUTTON)));

        actor.attemptsTo(todoList.toArray(new Performable[]{}));
    }

    public Performable withTheValueOf(Enum value) {
        this.value = value;
        return this;
    }
}
