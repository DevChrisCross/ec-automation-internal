package com.elavon.constants;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.Map;

public enum SearchFilter implements Bindable {
    GROUP,
    ENTITY,
    MCC,
    MERCHANT_ID,
    FIRST_NAME,
    LAST_NAME,
    TAX_ID,
    EMAIL,
    USER_ID;

    public static Map<Class<? extends PageObject>, Map<Bindable, Map<String, Target>>> bindMap = new HashMap<>();
}
