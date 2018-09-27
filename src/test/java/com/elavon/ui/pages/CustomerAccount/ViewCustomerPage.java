package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.BindMap;
import com.elavon.helper.LocatorCounter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ViewCustomerPage extends PageObject {

    public static BindMap<String, Target> bind;

    public static final Target ACCOUNT_OPTIONS = Target
            .the("account options")
            .located(By.id("editUserOverflowMenu"));
    public static final Target DELETE_ACCOUNT_OPTION = Target
            .the("delete account option")
            .located(By.id("manageUserDeleteUser"));

    private static LocatorCounter accountActions = new LocatorCounter("button.md-button:nth-child(@COUNTER)");
    public static final Target CLONE_USER_BUTTON = Target
            .the("clone user button")
            .located(By.cssSelector(accountActions.valueOf(1)));
    public static final Target IMPERSONATE_BUTTON = Target
            .the("impersonate button")
            .located(By.cssSelector(accountActions.valueOf(2)));
    public static final Target RESET_PASSWORD_BUTTON = Target
            .the("reset password button")
            .located(By.cssSelector(accountActions.valueOf(3)));

    private static LocatorCounter editButtons = new LocatorCounter("/html/body/div[1]/span/md-content/" +
            "md-content/div/md-card[@COUNTER]/md-card-title/md-card-title-text/div[2]/button");
    public static final Target EDIT_PROFILE_BUTTON = Target
            .the("edit profile button")
            .located(By.xpath(editButtons.valueOf(2)));
    public static final Target EDIT_LOCATIONS_BUTTON = Target
            .the("edit locations button")
            .located(By.xpath(editButtons.valueOf(3)));

    public static class DeleteModal {

        private static LocatorCounter modalButton = new LocatorCounter("/html/body/div[5]/md-dialog/" +
                "md-dialog-actions/button[@COUNTER]");
        public static final Target DELETE_BUTTON = Target
                .the("delete button")
                .located(By.xpath(modalButton.valueOf(2)));
        public static final Target CANCEL_BUTTON = Target
                .the("cancel button")
                .located(By.xpath(modalButton.valueOf(1)));
    }

    public static class ResetModal {

        private static LocatorCounter modalButton = new LocatorCounter("/html/body/div[4]/md-dialog/" +
                "md-dialog-actions/button[@COUNTER]");
        public static final Target SEND_BUTTON = Target
                .the("send button")
                .located(By.xpath(modalButton.valueOf(2)));
        public static final Target CANCEL_BUTTON = Target
                .the("cancel button")
                .located(By.xpath(modalButton.valueOf(1)));
    }
}
