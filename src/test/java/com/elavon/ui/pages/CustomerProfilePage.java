package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.apache.tools.ant.taskdefs.Tar;
import org.openqa.selenium.By;

public class CustomerProfilePage extends PageObject {

    public static final Target ACCOUNT_OPTIONS =
            Target.the("account options").located(By.id("editUserOverflowMenu"));
    public static final Target DELETE_ACCOUNT_OPTION =
            Target.the("delete account option").located(By.id("manageUserDeleteUser"));
    public static final Target CLONE_USER_BUTTON =
            Target.the("clone user button")
                    .located(By.cssSelector(".layout-align-end-center > button:nth-child(1)"));
    public static final Target IMPERSONATE_BUTTON =
            Target.the("impersonate button")
                    .located(By.cssSelector("button.md-button:nth-child(2)"));
    public static final Target RESET_PASSWORD_BUTTON =
            Target.the("impersonate button")
                    .located(By.cssSelector("button.md-button:nth-child(3)"));

    public static final Target DELETE_MODAL_DELETE_BUTTON =
            Target.the("delete button")
                    .located(By.xpath("/html/body/div[5]/md-dialog/md-dialog-actions/button[2]"));
    public static final Target DELETE_MODAL_CANCEL_BUTTON =
            Target.the("cancel button")
                    .located(By.xpath("/html/body/div[5]/md-dialog/md-dialog-actions/button[1]"));

    public static final Target RESET_MODAL_SEND_BUTTON =
            Target.the("send button")
                    .located(By.xpath("/html/body/div[4]/md-dialog/md-dialog-actions/button[2]"));
    public static final Target RESET_MODAL_CANCEL_BUTTON =
            Target.the("cancel button")
                    .located(By.xpath("/html/body/div[4]/md-dialog/md-dialog-actions/button[1]"));

    public static final Target IMPERSONATE_END_BUTTON =
            Target.the("end button")
                    .located(By.id("endimpersonate"));

    public static final Target ACCOUNT_DETAILS_CARD =
            Target.the("account details card")
                    .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/md-card[1]"));

    public static final Target IMPERSONATED_DASHBOARD =
            Target.the("impersonated dashboard")
                    .located(By.id("mainpanel"));
}
