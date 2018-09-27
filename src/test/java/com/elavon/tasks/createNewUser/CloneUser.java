package com.elavon.tasks.createNewUser;

import com.elavon.constants.UserLanguage;
import com.elavon.constants.UserRole;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.CustomerAccount.CloneCustomerPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class CloneUser implements Task {

    private String userId;
    private String email;
    private UserLanguage language;
    private UserRole role;

    public CloneUser() {
        userId = "r@r";
        email = "r@r.r";
        language = UserLanguage.ENGLISH;
        role = UserRole.MANAGER;
    }

    @Override
    @Step("")
    public <T extends Actor> void performAs(T actor) {
        String[] name = userId.split("@");
        Target valueToSelect = CloneCustomerPage.bind.getDefaultItem(language);

        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.CLONE_USER_BUTTON),
                Enter.theValue(name[0]).into(CloneCustomerPage.FIRST_NAME_FIELD),
                Enter.theValue(name[1]).into(CloneCustomerPage.LAST_NAME_FIELD),
                Enter.theValue(email).into(CloneCustomerPage.EMAIL_FIELD),
                Click.on(CloneCustomerPage.LANGUAGE_DROPDOWN),
                Click.on(valueToSelect),
                ClickOn.the(CloneCustomerPage.NEXT_BUTTON)

                // TODO: satisfy fields for role, and name generation for creation of user
        );
    }

    public CloneUser withUserIdOf(String userId) {
        this.userId = userId;
        return this;
    }

    public CloneUser withEmailOf(String email) {
        this.email = email;
        return this;
    }

    public CloneUser withLanguageOf(UserLanguage language) {
        this.language = language;
        return this;
    }

    public CloneUser withRoleOf(UserRole role) {
        this.role = role;
        return this;
    }
}

