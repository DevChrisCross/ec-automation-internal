package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.DataBind;
import com.elavon.helper.LocatorCounter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class EditCustomerProfilePage extends PageObject {

    public static DataBind<String, Target> bind;

    private static LocatorCounter update = new LocatorCounter("//md-card-actions/button[@COUNTER]");
    public static final Target UPDATE_BUTTON = Target
            .the("update button")
            .located(By.xpath(update.valueOf(2)));
    public static final Target CANCEL_BUTTON = Target
            .the("cancel button")
            .located(By.xpath(update.valueOf(1)));

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
            .located(By.xpath("//md-list-item/md-input-container/md-select"));

    public static class Language {

        protected static String languageOption = "//md-select-menu/md-content/md-option";
        public static final Target DEUTSCH_OPTION = Target
                .the("deutsch option")
                .located(By.xpath(languageOption + "[@value=\"de_DE\"]"));
        public static final Target ENGLISH_OPTION = Target
                .the("english option")
                .located(By.xpath(languageOption + "[@value=\"en_GB\"]"));
        public static final Target ESPANOL_OPTION = Target
                .the("espanol option")
                .located(By.xpath(languageOption + "[@value=\"es_ES\"]"));
        public static final Target FRANCAIS_OPTION = Target
                .the("francais option")
                .located(By.xpath(languageOption + "[@value=\"fr_FR\"]"));
        public static final Target ITALIANO_OPTION = Target
                .the("italiano option")
                .located(By.xpath(languageOption + "[@value=\"it_IT\"]"));
        public static final Target NEDERLANDS_OPTION = Target
                .the("nederlands option")
                .located(By.xpath(languageOption + "[@value=\"nl_NL\"]"));
        public static final Target NORSK_OPTION = Target
                .the("norsk option")
                .located(By.xpath(languageOption + "[@value=\"no_NO\"]"));
        public static final Target POLSKI_OPTION = Target
                .the("polski option")
                .located(By.xpath(languageOption + "[@value=\"pl_PL\"]"));
    }

    public static class Role {

        private static LocatorCounter roleOption = new LocatorCounter("//md-radio-group/div[@COUNTER]/div[1]/" +
                "md-radio-button");
        public static final Target EMPLOYEE_RADIO_BUTTON = Target
                .the("employee radio button")
                .located(By.xpath(roleOption.valueOf(1)));
        public static final Target MANAGER_RADIO_BUTTON = Target
                .the("manager radio button")
                .located(By.xpath(roleOption.valueOf(2)));
    }
}
