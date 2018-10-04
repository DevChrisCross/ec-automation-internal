package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.DataBind;
import com.elavon.helper.LocatorCounter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class EditReportsPage extends PageObject {

    public static DataBind<String, Target> bind;

    private static LocatorCounter button = new LocatorCounter("//md-card-actions/button[@COUNTER]");
    public static final Target UPDATE_BUTTON = Target
            .the("update button")
            .located(By.xpath(button.valueOf(2)));
    public static final Target CANCEL_BUTTON = Target
            .the("cancel button")
            .located(By.xpath(button.valueOf(1)));

    public static class Available {

        public static final Target SELECT_ALL_CHECKBOX = Target
                .the("select all checkbox")
                .located(By.xpath("//reports-tree/div/div[1]/md-checkbox[@aria-label=\"Select All\"]"));

        private static String reports = "//reports-tree-node/div/div[1]/md-checkbox";
        public static final Target STANDARD_NONPARTNER_REPORTS_CHECKBOX = Target
                .the("standard non-partner reports checkbox")
                .located(By.xpath(reports + "[@aria-label=\"STANDARD_NONPARTNER_REPORTS\"]"));
        public static final Target STANDARD_PARTNER_REPORTS_CHECKBOX = Target
                .the("standard partner reports checkbox")
                .located(By.xpath(reports + "[@aria-label=\"STANDARD_PARTNER_REPORTS\"]"));
        public static final Target DISPUTE_REPORTS_CHECKBOX = Target
                .the("dispute reports checkbox")
                .located(By.xpath(reports + "[@aria-label=\"DISPUTE_REPORTS\"]"));
        public static final Target DCC_REPORTS_CHECKBOX = Target
                .the("dcc reports checkbox")
                .located(By.xpath(reports + "[@aria-label=\"DCC_REPORTS\"]"));
        public static final Target INTERCHANGE_REPORTS_CHECKBOX = Target
                .the("interchange reports checkbox")
                .located(By.xpath(reports + "[@aria-label=\"INTERCHANGE_REPORTS\"]"));
        public static final Target AUTHORIZATIONS_REPORTS_CHECKBOX = Target
                .the("authorizations reports checkbox")
                .located(By.xpath(reports + "[@aria-label=\"AUTHORIZATIONS_REPORTS\"]"));
        public static final Target OPTIONAL_REPORTS_CHECKBOX = Target
                .the("optional reports checkbox")
                .located(By.xpath(reports + "[@aria-label=\"OPTIONAL_REPORTS\"]"));
    }

}
