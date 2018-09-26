package com.elavon.tasks.modifyUserProfile;

import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ImpersonateUser implements Task {

    private String userId;

    public ImpersonateUser(String userId) {
        this.userId = userId;
    }

    @Override
    @Step("{0} impersonates the user's account")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.IMPERSONATE_BUTTON)
        );
    }
}
