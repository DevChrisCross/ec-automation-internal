package com.elavon.binder;

import com.elavon.constants.*;
import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.HomePage;
import com.elavon.ui.pages.UserProfilePage;
import com.google.common.collect.ImmutableMap;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PageBind {

    public static List<Class<? extends PageObject>> pages = new ArrayList<>(Arrays.asList(
            HomePage.class,
            CustomerSearchPage.class,
            UserProfilePage.class
    ));

    public static List<DataBind<?, ?>> dataBinds = new ArrayList<>(Arrays.asList(
            new DataBind<>(HomePage.class, HomeNav.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("target", new Object(), "url", "welcome"),
                    ImmutableMap.of("target", HomePage.LOGIN_BUTTON, "url", "login"),
                    ImmutableMap.of("target", HomePage.CONTACT_US_BUTTON, "url", "contactus"),
                    ImmutableMap.of("target", HomePage.TERMS_OF_USE_LINK, "url", "termsOfUseEu"),
                    ImmutableMap.of("target", HomePage.COOKIES_POLICY_LINK, "url", "cookiesPolicyEu")))),

            new DataBind<>(CustomerSearchPage.class, SearchBy.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("target", CustomerSearchPage.LOCATION_TAB_BUTTON),
                    ImmutableMap.of("target", CustomerSearchPage.USER_TAB_BUTTON)))),

            new DataBind<>(CustomerSearchPage.class, SearchFilter.class, new LinkedList<>(Arrays.asList(
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
                            "field", CustomerSearchPage.USER_ID_FIELD)))),

            new DataBind<>(UserProfilePage.class, UserProfile.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("target", UserProfilePage.CUSTOMER_FIRST_NAME_FIELD),
                    ImmutableMap.of("target", UserProfilePage.CUSTOMER_LAST_NAME_FIELD),
                    ImmutableMap.of("target", UserProfilePage.CUSTOMER_EMAIL_FIELD),
                    ImmutableMap.of("target", UserProfilePage.CUSTOMER_LANGUAGE_DROPDOWN),
                    ImmutableMap.of("employee option", UserProfilePage.CUSTOMER_EMPLOYEE_RBUTTON,
                            "manager option", UserProfilePage.CUSTOMER_MANAGER_RBUTTON)))),

            new DataBind<>(UserProfilePage.class, UserLanguage.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("option", UserProfilePage.CUSTOMER_DEUTSCH_OPTION),
                    ImmutableMap.of("option", UserProfilePage.CUSTOMER_ENGLISH_OPTION),
                    ImmutableMap.of("option", UserProfilePage.CUSTOMER_ESPANOL_OPTION),
                    ImmutableMap.of("option", UserProfilePage.CUSTOMER_FRANCAIS_OPTION),
                    ImmutableMap.of("option", UserProfilePage.CUSTOMER_ITALIANO_OPTION),
                    ImmutableMap.of("option", UserProfilePage.CUSTOMER_NEDERLANDS_OPTION),
                    ImmutableMap.of("option", UserProfilePage.CUSTOMER_NORSK_OPTION),
                    ImmutableMap.of("option", UserProfilePage.CUSTOMER_POLSKI_OPTION))))
    ));
}
