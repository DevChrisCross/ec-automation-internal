package com.elavon.ui.pages.CustomerAccount;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ImpersonateCustomerPage extends PageObject {

    public static final Target IMPERSONATE_END_BUTTON = Target
            .the("end button")
            .located(By.id("endimpersonate"));
}
