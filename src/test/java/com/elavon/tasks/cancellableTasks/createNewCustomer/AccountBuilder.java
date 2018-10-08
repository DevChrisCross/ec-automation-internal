package com.elavon.tasks.cancellableTasks.createNewCustomer;

import com.elavon.constants.user.UserLanguage;
import com.elavon.constants.user.UserLocationRule;
import com.elavon.constants.user.UserRole;
import com.elavon.model.Location;
import com.elavon.model.UserAccount;
import net.serenitybdd.core.steps.Instrumented;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountBuilder<T> {

    Class<T> aClass;
    private UserAccount account;

    public AccountBuilder(Class<T> aClass) {
        this.aClass = aClass;
        account = new UserAccount();
    }

    public AccountBuilder<T> withTheRoleOf(UserRole role) {
        account.setRole(role);
        return this;
    }

    public AccountBuilder<T> withTheLanguageOf(UserLanguage language) {
        account.setLanguage(language);
        return this;
    }

    public AccountBuilder<T> withTheLocationOf(String... locations) {
        List<String> locationList = new ArrayList<>(Arrays.asList(locations));
        locationList.forEach(location -> {
            String[] loc = location.split("-");
            account.getLocations().add(new Location(UserLocationRule.valueOf(loc[0]), loc[1], loc[2]));
        });
        return this;
    }

    public T typeOfAccount() {
        return Instrumented.instanceOf(aClass).withProperties(account);
    }
}
