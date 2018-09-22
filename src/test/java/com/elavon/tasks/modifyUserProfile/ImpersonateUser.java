package com.elavon.tasks.modifyUserProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.genericTasks.View;
import com.elavon.ui.pages.ViewUserProfilePage;
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
                ClickOn.the(ViewUserProfilePage.IMPERSONATE_BUTTON)
        );
    }
}
