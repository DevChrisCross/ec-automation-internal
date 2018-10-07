package com.elavon.tasks.createNewCustomer;

import com.elavon.constants.user.UserLanguage;
import com.elavon.constants.user.UserRole;
import com.elavon.tasks.Cancellable;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public abstract class CreateAccount extends Cancellable {

    private static PropertiesConfiguration generate;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected UserLanguage language;
    protected UserRole role;

    public CreateAccount() {
        generate = null;
        try {
            generate = new PropertiesConfiguration("generate.properties");
            firstName = generate.getString("user.base.first") + generate.getString("user.count");
            lastName = generate.getString("user.base.last");
            email = generate.getString("user.email");
            language = UserLanguage.ENGLISH;
            role = UserRole.MANAGER;

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public CreateAccount withTheRoleOf(UserRole role) {
        this.role = role;
        return this;
    }

    public CreateAccount withTheLanguageOf(UserLanguage language) {
        this.language = language;
        return this;
    }

    protected void increaseUserCount() {
        try {
            if (isCompletely) {
                int count = generate.getInt("user.count");
                generate.setProperty("user.count", ++count);
                generate.save();
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    protected FillUpCustomerInformation provideDefaultInformation() {
        return FillUpCustomerInformation.withDetailsOf(firstName, lastName, email, language, role);
    }
}
