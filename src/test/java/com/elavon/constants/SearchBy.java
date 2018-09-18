package com.elavon.constants;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.Map;

public enum SearchBy implements Bindable {
    LOCATION,
    USER;

    public static Map<Class<? extends PageObject>, Map<Bindable, Map<String, Target>>> bindMap = new HashMap<>();
}
