package com.elavon.tasks.userProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.general.View;
import com.elavon.ui.pages.UserProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ImpersonateUser implements Task {

    private String userId;

    public ImpersonateUser(String userId) {
        this.userId = userId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                View.theUserProfileOf(userId),
                ClickOn.the(UserProfilePage.IMPERSONATE_BUTTON)
        );
    }
}
