package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InternalHomePage {

    public static final Target NAVIGATION_SIDEBAR =
            Target.the("navigation sidebar").located(By.id("sidebarNav"));
    public static final Target CUSTOMER_SEARCH_TAB =
            Target.the("customer search tab").located(By.id("sidebarSearch"));
}
