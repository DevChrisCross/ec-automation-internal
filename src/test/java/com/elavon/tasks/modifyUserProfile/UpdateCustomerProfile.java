package com.elavon.tasks.modifyUserProfile;

import com.elavon.binder.Binder;
import com.elavon.constants.UserProfile;
import com.elavon.constants.UserRole;
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
        Target target = Binder.userProfileMap.get(ViewUserProfilePage.class).get(userProfile).get("target");
        List<Performable> todoList = new ArrayList<>();

        todoList.add(ClickOn.the(ViewUserProfilePage.EDIT_PROFILE_BUTTON));
        if (userProfile.equals(UserProfile.FIRST_NAME) ||
                userProfile.equals(UserProfile.LAST_NAME) ||
                userProfile.equals(UserProfile.EMAIL)) {
            todoList.add(Enter.theValue((String) value).into(target));
        }
        if (userProfile.equals(UserProfile.LANGUAGE)) {
            todoList.add(Click.on(target));
            todoList.add(Click.on(Binder.userLanguageMap.get(ViewUserProfilePage.class)
                    .get(value).get("option")));
        }
        if (userProfile.equals(UserProfile.ROLE)) {
            if (value.equals(UserRole.EMPLOYEE)) {
                todoList.add(Click.on(EditUserProfilePage.Role.EMPLOYEE_RADIO_BUTTON));
            }
            if (value.equals(UserRole.MANAGER)) {
                todoList.add(Click.on(EditUserProfilePage.Role.MANAGER_RADIO_BUTTON));
            }
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