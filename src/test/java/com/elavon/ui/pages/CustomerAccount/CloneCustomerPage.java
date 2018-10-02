package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.DataBind;
import com.elavon.helper.LocatorCounter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CloneCustomerPage extends EditCustomerProfilePage {

    public static DataBind<String, Target> bind;

    public static final Target CANCEL_BUTTON = EditCustomerProfilePage.CANCEL_BUTTON;
    public static final Target NEXT_BUTTON = EditCustomerProfilePage.UPDATE_BUTTON;

    public static class Confirmation {

        private static LocatorCounter confirm = new LocatorCounter("//md-content/div/div/button[@COUNTER]");
        public static final Target BACK_BUTTON = Target
                .the("back button")
                .located(By.xpath(confirm.valueOf(1)));
        public static final Target CREATE_USER_BUTTON = Target
                .the("create user button")
                .located(By.xpath(confirm.valueOf(2)));
    }

    public static class Role {

        private static LocatorCounter roleOption = new LocatorCounter("//md-card-content/div[2]/div/" +
                "md-radio-group/div[1]/md-radio-button[@COUNTER]");
        public static final Target EMPLOYEE_RADIO_BUTTON = Target
                .the("employee radio button")
                .located(By.xpath(roleOption.valueOf(2)));
        public static final Target MANAGER_RADIO_BUTTON = Target
                .the("manager radio button")
                .located(By.xpath(roleOption.valueOf(1)));
        public static final Target PARTNER_USER_RADIO_BUTTON = Target
                .the("partner bank user radio button")
                .located(By.xpath("//md-card-content/div/md-radio-group/div[2]/md-radio-button"));
    }

}
