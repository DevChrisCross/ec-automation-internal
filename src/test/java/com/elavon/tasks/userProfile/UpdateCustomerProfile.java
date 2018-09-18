package com.elavon.tasks.userProfile;

import com.elavon.constants.UserProfile;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.UserProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.ArrayList;
import java.util.List;

public class UpdateCustomerProfile implements Task {

    private UserProfile userProfile;
    private String value;

    public UpdateCustomerProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Performable> todoList = new ArrayList<>();

        todoList.add(ClickOn.the(UserProfilePage.EDIT_PROFILE_BUTTON));
        if (userProfile.equals(UserProfile.FIRST_NAME) ||
                userProfile.equals(UserProfile.LAST_NAME) ||
                userProfile.equals(UserProfile.EMAIL)) {
            todoList.add(Enter.theValue(value).into(UserProfilePage.CUSTOMER_FIRST_NAME_FIELD));
        }
        if (userProfile.equals(UserProfile.LANGUAGE)) {
            todoList.add(Click.on(UserProfilePage.CUSTOMER_LANGUAGE_DROPDOWN));
            todoList.add(Click.on(UserProfilePage.CUSTOMER_DEUTSCH_OPTION));
        }
        if (userProfile.equals(UserProfile.ROLE)) {
            todoList.add(Click.on(UserProfilePage.CUSTOMER_MANAGER_RBUTTON));
        }
        todoList.add(ClickOn.the(UserProfilePage.CUSTOMER_UPDATE_BUTTON));

        Performable[] todoActions = todoList.toArray(new Performable[]{});
        actor.attemptsTo(todoActions);
    }

    public Performable withTheValueOf(String value) {
        this.value = value;
        return this;
    }
}
