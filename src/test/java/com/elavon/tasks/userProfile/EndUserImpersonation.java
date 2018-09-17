package com.elavon.tasks.userProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.wait.WaitUntilThe;
import com.elavon.ui.pages.CustomerProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class EndUserImpersonation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(CustomerProfilePage.IMPERSONATE_END_BUTTON)
        );
    }
}
