package com.elavon.ui.pages.CustomerAccount;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class EditReportsPage extends PageObject {

    public static final Target REPORT_CHECKBOX = Target
            .the("report checkbox")
            .locatedBy("//reports-tree-node/div/div/md-checkbox[@aria-label=\"{0}\"]");
    public static final Target REPORT_REMOVE_BUTTON = Target
            .the("report remove button")
            .locatedBy("//assigned-reports/div[contains(.,\"{0}\")]/div/div/i");
}
