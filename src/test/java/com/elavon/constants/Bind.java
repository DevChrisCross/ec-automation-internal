package com.elavon.constants;

import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.HomePage;
import com.google.common.collect.ImmutableMap;
import net.thucydides.core.pages.PageObject;

import java.util.*;

public class Bind {

    public static <K, V> void bindTargets(
            Map<Class<? extends PageObject>, Map<Bindable, Map<K, V>>> bindMap,
            Class<? extends Bindable> enumObject,
            Class<? extends PageObject> pageObject,
            Queue<Map<K, V>> targets) {
        Map<Bindable, Map<K, V>> bindableTargetMap = new HashMap<>();
        for (Bindable enumConstant : enumObject.getEnumConstants()) {
            bindableTargetMap.put(enumConstant, targets.poll());
        }
        bindMap.put(pageObject, bindableTargetMap);
    }

    public static void loadBinders() {
        bindTargets(Page.bindMap,
                Page.class,
                HomePage.class,
                new LinkedList<>(Arrays.asList(
                        ImmutableMap.of("target", new Object(), "url", "welcome"),
                        ImmutableMap.of("target", HomePage.LOGIN_BUTTON, "url", "login"),
                        ImmutableMap.of("target", HomePage.CONTACT_US_BUTTON, "url", "contactus"),
                        ImmutableMap.of("target", HomePage.TERMS_OF_USE_LINK, "url", "termsOfUseEu"),
                        ImmutableMap.of("target", HomePage.COOKIES_POLICY_LINK, "url", "cookiesPolicyEu")
                )));

        bindTargets(SearchBy.bindMap,
                SearchBy.class,
                CustomerSearchPage.class,
                new LinkedList<>(Arrays.asList(
                        ImmutableMap.of("target", CustomerSearchPage.LOCATION_TAB_BUTTON),
                        ImmutableMap.of("target", CustomerSearchPage.USER_TAB_BUTTON)
                )));

        bindTargets(SearchFilter.bindMap,
                SearchFilter.class,
                CustomerSearchPage.class,
                new LinkedList<>(Arrays.asList(
                        ImmutableMap.of("option", CustomerSearchPage.GROUP_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.GROUP_FIELD),
                        ImmutableMap.of("option", CustomerSearchPage.ENTITY_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.ENTITY_FIELD),
                        ImmutableMap.of("option", CustomerSearchPage.MCC_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.MCC_FIELD),
                        ImmutableMap.of("option", CustomerSearchPage.MERCHANT_ID_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.MERCHANT_ID_FIELD),
                        ImmutableMap.of("option", CustomerSearchPage.NAME_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.FIRST_NAME_FIELD),
                        ImmutableMap.of("option", CustomerSearchPage.NAME_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.LAST_NAME_FIELD),
                        ImmutableMap.of("option", CustomerSearchPage.TAX_ID_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.TAX_ID_FIELD),
                        ImmutableMap.of("option", CustomerSearchPage.EMAIL_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.EMAIL_FIELD),
                        ImmutableMap.of("option", CustomerSearchPage.USER_ID_DROPDOWN_OPTION,
                                "field", CustomerSearchPage.USER_ID_FIELD)
                )));
    }
}
