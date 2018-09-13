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

    public static final Target DELETE_BUTTON =
            Target.the("delete button")
                    .located(By.xpath("/html/body/div[5]/md-dialog/md-dialog-actions/button[2]"));
    public static final Target CANCEL_BUTTON =
            Target.the("cancel button")
                    .located(By.xpath("/html/body/div[5]/md-dialog/md-dialog-actions/button[1]"));
}
