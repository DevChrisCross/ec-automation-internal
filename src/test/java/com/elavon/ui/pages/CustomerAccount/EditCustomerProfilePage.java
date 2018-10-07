package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.DataBind;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class EditCustomerProfilePage extends PageObject {

    public static DataBind<String, Target> bind;

    public static final Target FIRST_NAME_FIELD = Target
            .the("first name field")
            .located(By.id("customerFirstName"));
    public static final Target LAST_NAME_FIELD = Target
            .the("last name field")
            .located(By.id("customerLastName"));
    public static final Target EMAIL_FIELD = Target
            .the("last name field")
            .located(By.id("customerEmail"));
    public static final Target LANGUAGE_DROPDOWN = Target
            .the("language dropdown")
            .locatedBy("//md-list-item/md-input-container/md-select");

    public static class Language {

        public static final Target LANGUAGE_OPTION = Target
                .the("language option")
                .locatedBy("//md-select-menu/md-content/md-option[@value=\"{0}\"]");
        public static final Target DEUTSCH_OPTION = LANGUAGE_OPTION.of("de_DE");
        public static final Target ENGLISH_OPTION = LANGUAGE_OPTION.of("en_GB");
        public static final Target ESPANOL_OPTION = LANGUAGE_OPTION.of("es_ES");
        public static final Target FRANCAIS_OPTION = LANGUAGE_OPTION.of("fr_FR");
        public static final Target ITALIANO_OPTION = LANGUAGE_OPTION.of("it_IT");
        public static final Target NEDERLANDS_OPTION = LANGUAGE_OPTION.of("nl_NL");
        public static final Target NORSK_OPTION = LANGUAGE_OPTION.of("no_NO");
        public static final Target POLSKI_OPTION = LANGUAGE_OPTION.of("pl_PL");
    }

    public static class Role {

        public static final Target ROLE_OPTION = Target
                .the("role option")
                .locatedBy("//md-radio-group/div[{0}]/div[1]/md-radio-button");
        public static final Target EMPLOYEE_RADIO_BUTTON = ROLE_OPTION.of("1").called("employee radio button");
        public static final Target MANAGER_RADIO_BUTTON = ROLE_OPTION.of("2").called("manager radio button");
    }
}
