package com.elavon.constants;

import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.Map;

public enum Page implements Bindable {
    HOME,
    LOGIN,
    CONTACT_US,
    TERMS_OF_USE,
    COOKIES_POLICY;

    public static Map<Class<? extends PageObject>, Map<Bindable, Map<String, Object>>> bindMap = new HashMap<>();
}
