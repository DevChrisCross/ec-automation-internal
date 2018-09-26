package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.BindMap;
import com.elavon.helper.LocatorGenerator;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class EditCustomerProfilePage extends PageObject {

    private static LocatorGenerator update = new LocatorGenerator("/html/body/div[1]/span/md-content/" +
            "md-content/div/form/md-card[3]/md-card-content/md-card-actions/button[@COUNTER]");
    public static final Target UPDATE_BUTTON = Target
            .the("customer update button")
            .located(By.xpath(update.generate(2)));
    public static final Target CANCEL_BUTTON = Target
            .the("cancel button")
            .located(By.xpath(update.generate(1)));

    public static final Target CUSTOMER_FIRST_NAME_FIELD = Target
            .the("customer first name field")
            .located(By.id("customerFirstName"));
    public static final Target CUSTOMER_LAST_NAME_FIELD = Target
            .the("customer last name field")
            .located(By.id("customerLastName"));
    public static final Target CUSTOMER_EMAIL_FIELD = Target
            .the("customer last name field")
            .located(By.id("customerEmail"));
    public static BindMap<String, Target> bind;

    public static class Language {

        public static final Target DROPDOWN = Target
                .the("customer language dropdown")
                .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/form/md-card[1]/" +
                        "md-card-content/div[3]/md-list-item/md-input-container/md-select"));

        private static LocatorGenerator languageOption = new LocatorGenerator("/html/body/div[4]/md-select-menu/" +
                "md-content/md-option[@COUNTER]");
        public static final Target DEUTSCH_OPTION = Target
                .the("customer deutsch option")
                .located(By.xpath(languageOption.generate(1)));
        public static final Target ENGLISH_OPTION = Target
                .the("customer english option")
                .located(By.xpath(languageOption.generate(2)));
        public static final Target ESPANOL_OPTION = Target
                .the("customer espanol option")
                .located(By.xpath(languageOption.generate(3)));
        public static final Target FRANCAIS_OPTION = Target
                .the("customer francais option")
                .located(By.xpath(languageOption.generate(4)));
        public static final Target ITALIANO_OPTION = Target
                .the("customer italiano option")
                .located(By.xpath(languageOption.generate(5)));
        public static final Target NEDERLANDS_OPTION = Target
                .the("customer nederlands option")
                .located(By.xpath(languageOption.generate(6)));
        public static final Target NORSK_OPTION = Target
                .the("customer norsk option")
                .located(By.xpath(languageOption.generate(7)));
        public static final Target POLSKI_OPTION = Target
                .the("customer polski option")
                .located(By.xpath(languageOption.generate(8)));
    }

    public static class Role {

        private static LocatorGenerator roleOption = new LocatorGenerator("/html/body/div[1]/span/md-content/md-content/" +
                "div/form/md-card[2]/md-card-content/div/md-input-container/md-radio-group/div[@COUNTER]/div[1]/" +
                "md-radio-button");
        public static final Target EMPLOYEE_RADIO_BUTTON = Target
                .the("customer employee radio button")
                .located(By.xpath(roleOption.generate(1)));
        public static final Target MANAGER_RADIO_BUTTON = Target
                .the("customer manager radio button")
                .located(By.xpath(roleOption.generate(2)));
    }
}
