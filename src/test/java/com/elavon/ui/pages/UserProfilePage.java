package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class UserProfilePage extends PageObject {

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

    public static final Target EDIT_PROFILE_BUTTON =
            Target.the("edit profile button")
                    .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/md-card[2]/" +
                            "md-card-title/md-card-title-text/div[2]/button"));
    public static final Target CUSTOMER_UPDATE_BUTTON =
            Target.the("customer update button")
                    .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/form/md-card[3]/" +
                            "md-card-content/md-card-actions/button[2]"));

    public static final Target CUSTOMER_FIRST_NAME_FIELD =
            Target.the("customer first name field").located(By.id("customerFirstName"));
    public static final Target CUSTOMER_LAST_NAME_FIELD =
            Target.the("customer last name field").located(By.id("customerLastName"));
    public static final Target CUSTOMER_EMAIL_FIELD =
            Target.the("customer last name field").located(By.id("customerEmail"));
    public static final Target CUSTOMER_LANGUAGE_DROPDOWN =
            Target.the("customer language dropdown")
                    .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/form/md-card[1]/" +
                            "md-card-content/div[3]/md-list-item/md-input-container/md-select"));

    public static final Target CUSTOMER_DEUTSCH_OPTION =
            Target.the("customer deutsch option")
                    .located(By.xpath("/html/body/div[4]/md-select-menu/md-content/md-option[1]"));
    public static final Target CUSTOMER_ENGLISH_OPTION =
            Target.the("customer english option")
                    .located(By.xpath("/html/body/div[4]/md-select-menu/md-content/md-option[2]"));
    public static final Target CUSTOMER_ESPANOL_OPTION =
            Target.the("customer espanol option")
                    .located(By.xpath("/html/body/div[4]/md-select-menu/md-content/md-option[3]"));
    public static final Target CUSTOMER_FRANCAIS_OPTION =
            Target.the("customer francais option")
                    .located(By.xpath("/html/body/div[4]/md-select-menu/md-content/md-option[4]"));
    public static final Target CUSTOMER_ITALIANO_OPTION =
            Target.the("customer italiano option")
                    .located(By.xpath("/html/body/div[4]/md-select-menu/md-content/md-option[5]"));
    public static final Target CUSTOMER_NEDERLANDS_OPTION =
            Target.the("customer nederlands option")
                    .located(By.xpath("/html/body/div[4]/md-select-menu/md-content/md-option[6]"));
    public static final Target CUSTOMER_NORSK_OPTION =
            Target.the("customer norsk option")
                    .located(By.xpath("/html/body/div[4]/md-select-menu/md-content/md-option[7]"));
    public static final Target CUSTOMER_POLSKI_OPTION =
            Target.the("customer polski option")
                    .located(By.xpath("/html/body/div[4]/md-select-menu/md-content/md-option[8]"));

    public static final Target CUSTOMER_EMPLOYEE_RBUTTON =
            Target.the("customer employee radio button")
                    .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/form/md-card[2]/" +
                            "md-card-content/div/md-input-container/md-radio-group/div[1]/div[1]/md-radio-button"));
    public static final Target CUSTOMER_MANAGER_RBUTTON =
            Target.the("customer manager radio button")
                    .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/form/md-card[2]/" +
                            "md-card-content/div/md-input-container/md-radio-group/div[2]/div[1]/md-radio-button"));

}
