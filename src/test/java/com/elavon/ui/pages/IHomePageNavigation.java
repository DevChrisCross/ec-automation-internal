package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class IHomePageNavigation extends PageObject {

    public static final Target CUSTOMER_SEARCH_TAB = Target
            .the("customer search tab")
            .located(By.id("sidebarSearch"));
}
