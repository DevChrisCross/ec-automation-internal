package com.elavon.ui.pages;

import com.elavon.binder.BindMap;
import com.elavon.binder.Binder;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ViewUserProfilePage extends PageObject {

    public static final BindMap<String, Target> bind = Binder.bindMapOf(ViewUserProfilePage.class);

    public static final Target ACCOUNT_OPTIONS = Target
            .the("account options")
            .located(By.id("editUserOverflowMenu"));
    public static final Target DELETE_ACCOUNT_OPTION = Target
            .the("delete account option")
            .located(By.id("manageUserDeleteUser"));

    public static final Target CLONE_USER_BUTTON = Target
            .the("clone user button")
            .located(By.cssSelector("button.md-button:nth-child(1)"));
    public static final Target IMPERSONATE_BUTTON = Target
            .the("impersonate button")
            .located(By.cssSelector("button.md-button:nth-child(2)"));
    public static final Target RESET_PASSWORD_BUTTON = Target
            .the("impersonate button")
            .located(By.cssSelector("button.md-button:nth-child(3)"));

    public static final Target EDIT_PROFILE_BUTTON = Target
            .the("edit profile button")
            .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/md-card[2]/" +
                    "md-card-title/md-card-title-text/div[2]/button"));

    public static class DeleteModal {

        public static final Target DELETE_BUTTON = Target
                .the("delete button")
                .located(By.xpath("/html/body/div[5]/md-dialog/md-dialog-actions/button[2]"));
        public static final Target CANCEL_BUTTON = Target
                .the("cancel button")
                .located(By.xpath("/html/body/div[5]/md-dialog/md-dialog-actions/button[1]"));
    }

    public static class ResetModal {

        public static final Target SEND_BUTTON = Target
                .the("send button")
                .located(By.xpath("/html/body/div[4]/md-dialog/md-dialog-actions/button[2]"));
        public static final Target CANCEL_BUTTON = Target
                .the("cancel button")
                .located(By.xpath("/html/body/div[4]/md-dialog/md-dialog-actions/button[1]"));
    }
}
