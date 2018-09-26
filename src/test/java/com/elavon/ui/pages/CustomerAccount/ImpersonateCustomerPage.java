package com.elavon.ui.pages.CustomerAccount;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ImpersonateCustomerPage {

    public static final Target IMPERSONATE_END_BUTTON = Target
            .the("end button")
            .located(By.id("endimpersonate"));
}
