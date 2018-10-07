package com.elavon.ui.pages.CustomerAccount;

import com.elavon.helper.LocatorCounter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddNewCustomerPage extends CloneCustomerPage {

    public static final Target CLONE_EXISTING_BUTTON = Target
            .the("clone from existing button")
            .located(By.xpath("//md-card-content/div/div/button"));

    public static class CloneModal {

        public static final Target USERNAME_FIELD = Target
                .the("username field")
                .located(By.id("customerUsername"));

        public static final Target SEARCH_BUTTON = Target
                .the("searchButton")
                .located(By.id("cloneCustomerSearch"));

        private static LocatorCounter actions = new LocatorCounter("//md-dialog-actions/button[@COUNTER]");
        public static final Target NEXT_BUTTON = Target
                .the("next button")
                .located(By.xpath(actions.valueOf(2)));
    }
}
