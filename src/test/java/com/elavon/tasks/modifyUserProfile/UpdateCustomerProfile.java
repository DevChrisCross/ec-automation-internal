package com.elavon.tasks.modifyUserProfile;

import com.elavon.constants.UserProfile;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.EditUserProfilePage;
import com.elavon.ui.pages.ViewUserProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

public class UpdateCustomerProfile implements Task {

    private UserProfile userProfile;
    private Object value;

    public UpdateCustomerProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target target = ViewUserProfilePage.bind.getDefaultItem(userProfile);
        List<Performable> todoList = new ArrayList<>();

        todoList.add(ClickOn.the(ViewUserProfilePage.EDIT_PROFILE_BUTTON));
        if (userProfile.equals(UserProfile.FIRST_NAME)
                || userProfile.equals(UserProfile.LAST_NAME)
                || userProfile.equals(UserProfile.EMAIL)) {
            todoList.add(Enter.theValue((String) value).into(target));
        } else {
            if (userProfile.equals(UserProfile.LANGUAGE)) {
                todoList.add(Click.on(target));
            }
            todoList.add(Click.on(ViewUserProfilePage.bind.getDefaultItem(value)));
        }

        todoList.add(ClickOn.the(EditUserProfilePage.CUSTOMER_UPDATE_BUTTON));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }

    public Performable withTheValueOf(Object value) {
        this.value = value;
        return this;
    }
}
