package com.elavon.tasks.cancellableTasks.createNewCustomer;

import com.elavon.constants.user.UserLanguage;
import com.elavon.constants.user.UserLocationRule;
import com.elavon.constants.user.UserRole;
import com.elavon.model.Location;
import com.elavon.model.UserAccount;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;

public class AccountBuilder {

    Class<?> aClass;
    private UserAccount account;

    public AccountBuilder(Class<?> aClass) {
        this.aClass = aClass;
        account = new UserAccount();
    }

    public AccountBuilder withTheRoleOf(UserRole role) {
        account.setRole(role);
        return this;
    }

    public AccountBuilder withTheLanguageOf(UserLanguage language) {
        account.setLanguage(language);
        return this;
    }

    public AccountBuilder withTheLocationOf(String location) {
        String[] loc = location.split("-");
        account.getLocations().add(new Location(UserLocationRule.valueOf(loc[0]), loc[1], loc[2]));
        return this;
    }

    public Task typeOfAccount() {
        return (Task) Instrumented.instanceOf(aClass).withProperties(account);
    }
}
