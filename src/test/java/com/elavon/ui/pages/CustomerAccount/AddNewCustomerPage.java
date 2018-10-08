package com.elavon.ui.pages.CustomerAccount;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddNewCustomerPage extends CloneCustomerPage {

    public static final Target CLONE_EXISTING_BUTTON = Target
            .the("clone from existing button")
            .locatedBy("//md-card-content/div/div/button");

    public static class CloneModal {

        public static final Target USERNAME_FIELD = Target
                .the("username field")
                .located(By.id("customerUsername"));

        public static final Target SEARCH_BUTTON = Target
                .the("search button")
                .located(By.id("cloneCustomerSearch"));

        public static Target ACTION_BUTTON = Target
                .the("action button")
                .locatedBy("//md-dialog-actions/button[{0}]");
        public static final Target NEXT_BUTTON = ACTION_BUTTON.of("2").called("next button");
    }
}
