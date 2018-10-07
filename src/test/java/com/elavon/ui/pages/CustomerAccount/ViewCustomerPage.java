package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.DataBind;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ViewCustomerPage extends PageObject {

    public static DataBind<String, Target> bind;

    public static final Target ACCOUNT_OPTIONS = Target
            .the("account options")
            .located(By.id("editUserOverflowMenu"));
    public static final Target DELETE_ACCOUNT_OPTION = Target
            .the("delete account option")
            .located(By.id("manageUserDeleteUser"));

    public static final Target ACCOUNT_ACTIONS = Target
            .the("account actions")
            .locatedBy("//md-card-actions/button[{0}]");
    public static final Target CLONE_USER_BUTTON = ACCOUNT_ACTIONS.of("1").called("clone user button");
    public static final Target IMPERSONATE_BUTTON = ACCOUNT_ACTIONS.of("2").called("impersonate button");
    public static final Target RESET_PASSWORD_BUTTON = ACCOUNT_ACTIONS.of("3").called("reset password button");

    public static final Target EDIT_BUTTON = Target
            .the("edit button")
            .locatedBy("//md-card[{0}]/md-card-title/md-card-title-text/div[2]/button");
    public static final Target EDIT_PROFILE_BUTTON = EDIT_BUTTON.of("2").called("edit profile button");
    public static final Target EDIT_LOCATIONS_BUTTON = EDIT_BUTTON.of("3").called("edit locations button");
    public static final Target EDIT_REPORTS_BUTTON = EDIT_BUTTON.of("4").called("edit reports button");

    public static final Target RESET_MODAL_BUTTON = Target
            .the("reset modal button")
            .locatedBy("//div[4]/md-dialog/md-dialog-actions/button[{0}]");
    public static final Target DELETE_MODAL_BUTTON = Target
            .the("reset modal button")
            .locatedBy("//div[5]/md-dialog/md-dialog-actions/button[{0}]");
}
