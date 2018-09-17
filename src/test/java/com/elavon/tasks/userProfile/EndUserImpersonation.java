package com.elavon.tasks.userProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.UserProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class EndUserImpersonation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(UserProfilePage.IMPERSONATE_END_BUTTON)
        );
    }
}
