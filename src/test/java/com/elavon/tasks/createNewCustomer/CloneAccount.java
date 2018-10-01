package com.elavon.tasks.createNewCustomer;

import com.elavon.constants.UserLanguage;
import com.elavon.constants.UserRole;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.Cancellable;
import com.elavon.ui.pages.CustomerAccount.CloneCustomerPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class CloneAccount extends Cancellable implements Task {

    private String userId;
    private String email;
    private UserLanguage language;
    private UserRole role;
    private static PropertiesConfiguration generate;

    static {
        try {
            generate = new PropertiesConfiguration("generate.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public CloneAccount() {
        userId = generate.getString("user.base.first")
                + generate.getString("user.count")
                + generate.getString("user.separator")
                + generate.getString("user.base.last");
        email = generate.getString("user.email");
        language = UserLanguage.ENGLISH;
        role = UserRole.MANAGER;
    }

    @Override
    @Step("{0} clones the user account ")
    public <T extends Actor> void performAs(T actor) {
        String[] name = userId.split(generate.getString("user.separator"));
        Target valueToSelect = CloneCustomerPage.bind.getDefaultItem(language);

        if (isCompletely) {
            int count = generate.getInt("user.count");
            generate.setProperty("user.count", ++count);
            try {
                generate.save();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }

        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.CLONE_USER_BUTTON),
                Enter.theValue(name[0]).into(CloneCustomerPage.FIRST_NAME_FIELD),
                Enter.theValue(name[1]).into(CloneCustomerPage.LAST_NAME_FIELD),
                Enter.theValue(email).into(CloneCustomerPage.EMAIL_FIELD),
                Click.on(CloneCustomerPage.LANGUAGE_DROPDOWN),
                Click.on(valueToSelect),
                ClickOn.the(CloneCustomerPage.NEXT_BUTTON),
                SuccessOrFail(
                        new Performable[] { ClickOn.the(CloneCustomerPage.Confirmation.CREATE_USER_BUTTON) },
                        new Performable[] {
                                ClickOn.the(CloneCustomerPage.Confirmation.BACK_BUTTON),
                                ClickOn.the(CloneCustomerPage.CANCEL_BUTTON)
                        })
        );
    }

    public CloneAccount withUserIdOf(String userId) {
        this.userId = userId;
        return this;
    }

    public CloneAccount withEmailOf(String email) {
        this.email = email;
        return this;
    }

    public CloneAccount withLanguageOf(UserLanguage language) {
        this.language = language;
        return this;
    }

    public CloneAccount withRoleOf(UserRole role) {
        this.role = role;
        return this;
    }
}

