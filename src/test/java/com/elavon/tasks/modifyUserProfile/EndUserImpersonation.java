package com.elavon.tasks.modifyUserProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.ImpersonateUserProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class EndUserImpersonation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ImpersonateUserProfilePage.IMPERSONATE_END_BUTTON)
        );
    }
}
