package com.elavon.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InternalHomePage {

    public static final Target CUSTOMER_SEARCH_TAB =
            Target.the("customer customerSearch tab").located(By.id("sidebarSearch"));
}
