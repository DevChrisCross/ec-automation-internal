package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.DataBind;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CloneCustomerPage extends EditCustomerProfilePage {

    public static DataBind<String, Target> bind;

    public static final Target ACTION_BUTTON = Target
            .the("action button")
            .locatedBy("//md-card-actions/button[{0}]");
    public static final Target CANCEL_BUTTON = ACTION_BUTTON.of("1").called("cancel button");
    public static final Target NEXT_BUTTON = ACTION_BUTTON.of("2").called("update button");

    public static class Confirmation {

        public static final Target ACTION_BUTTON = Target
                .the("action button")
                .locatedBy("//md-content/div/div/button[{0}]");
        public static final Target BACK_BUTTON = ACTION_BUTTON.of("1").called("back button");
        public static final Target CREATE_USER_BUTTON = ACTION_BUTTON.of("2").called("create user button");
    }

    public static class Role {

        public static final Target ROLE_OPTION = Target
                .the("role option")
                .locatedBy("//md-card-content/div[2]/div/md-radio-group/div[1]/md-radio-button[{0}]");
        public static final Target EMPLOYEE_RADIO_BUTTON = ROLE_OPTION.of("2").called("employee radio button");
        public static final Target MANAGER_RADIO_BUTTON = ROLE_OPTION.of("1").called("manager radio button");
        public static final Target PARTNER_USER_RADIO_BUTTON = Target
                .the("partner bank user radio button")
                .located(By.xpath("//md-card-content/div/md-radio-group/div[2]/md-radio-button"));
    }

}
