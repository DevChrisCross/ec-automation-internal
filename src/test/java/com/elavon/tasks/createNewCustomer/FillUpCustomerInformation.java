package com.elavon.tasks.createNewCustomer;

import com.elavon.constants.UserLanguage;
import com.elavon.constants.UserRole;
import com.elavon.ui.pages.CustomerAccount.AddCustomerPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class FillUpCustomerInformation implements Task {

    private String firstName;
    private String lastName;
    private String email;
    private UserLanguage language;
    private UserRole role;

    public FillUpCustomerInformation(String firstName, String lastName, String email,
                                     UserLanguage language, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.language = language;
        this.role = role;
    }

    public static FillUpCustomerInformation withDetailsOf(String firstName, String lastName, String email,
                                                          UserLanguage language, UserRole role) {
        return Instrumented.instanceOf(FillUpCustomerInformation.class)
                .withProperties(firstName, lastName, email, language, role);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target languageToSelect = AddCustomerPage.bind.getDefaultItem(language);
        Target roleToSelect = AddCustomerPage.bind.getDefaultItem(role);

        actor.attemptsTo(
                Enter.theValue(firstName).into(AddCustomerPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(AddCustomerPage.LAST_NAME_FIELD),
                Enter.theValue(email).into(AddCustomerPage.EMAIL_FIELD),
                Click.on(AddCustomerPage.LANGUAGE_DROPDOWN),
                Click.on(languageToSelect),
                Click.on(roleToSelect)
        );

    }
}
