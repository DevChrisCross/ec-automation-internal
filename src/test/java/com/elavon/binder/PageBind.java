package com.elavon.binder;

import com.elavon.constants.*;
import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.EditUserProfilePage;
import com.elavon.ui.pages.GeneralHomePage;
import com.elavon.ui.pages.ViewUserProfilePage;
import com.google.common.collect.ImmutableMap;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PageBind {

    public static List<Class<? extends PageObject>> pages = new ArrayList<>(Arrays.asList(
            GeneralHomePage.class,
            CustomerSearchPage.class,
            ViewUserProfilePage.class
    ));

    public static List<DataBind<?, ?>> dataBinds = new ArrayList<>(Arrays.asList(
            new DataBind<>(GeneralHomePage.class, HomeNav.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("target", new Object(), "url", "welcome"),
                    ImmutableMap.of("target", GeneralHomePage.LOGIN_BUTTON, "url", "login"),
                    ImmutableMap.of("target", GeneralHomePage.CONTACT_US_BUTTON, "url", "contactus"),
                    ImmutableMap.of("target", GeneralHomePage.Footer.TERMS_OF_USE_LINK, "url", "termsOfUseEu"),
                    ImmutableMap.of("target", GeneralHomePage.Footer.COOKIES_POLICY_LINK, "url", "cookiesPolicyEu")))),

            new DataBind<>(CustomerSearchPage.class, SearchBy.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("target", CustomerSearchPage.LOCATION_TAB_BUTTON),
                    ImmutableMap.of("target", CustomerSearchPage.USER_TAB_BUTTON)))),

            new DataBind<>(CustomerSearchPage.class, SearchFilter.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("option", CustomerSearchPage.Filter.GROUP_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.GROUP_FIELD),
                    ImmutableMap.of("option", CustomerSearchPage.Filter.ENTITY_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.ENTITY_FIELD),
                    ImmutableMap.of("option", CustomerSearchPage.Filter.MCC_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.MCC_FIELD),
                    ImmutableMap.of("option", CustomerSearchPage.Filter.MERCHANT_ID_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.MERCHANT_ID_FIELD),
                    ImmutableMap.of("option", CustomerSearchPage.Filter.NAME_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.FIRST_NAME_FIELD),
                    ImmutableMap.of("option", CustomerSearchPage.Filter.NAME_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.LAST_NAME_FIELD),
                    ImmutableMap.of("option", CustomerSearchPage.Filter.TAX_ID_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.TAX_ID_FIELD),
                    ImmutableMap.of("option", CustomerSearchPage.Filter.EMAIL_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.EMAIL_FIELD),
                    ImmutableMap.of("option", CustomerSearchPage.Filter.USER_ID_DROPDOWN_OPTION,
                            "field", CustomerSearchPage.Filter.USER_ID_FIELD)))),

            new DataBind<>(ViewUserProfilePage.class, UserProfile.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("target", EditUserProfilePage.CUSTOMER_FIRST_NAME_FIELD),
                    ImmutableMap.of("target", EditUserProfilePage.CUSTOMER_LAST_NAME_FIELD),
                    ImmutableMap.of("target", EditUserProfilePage.CUSTOMER_EMAIL_FIELD),
                    ImmutableMap.of("target", EditUserProfilePage.Language.DROPDOWN),
                    ImmutableMap.of("employee option", EditUserProfilePage.Role.EMPLOYEE_RADIO_BUTTON,
                            "manager option", EditUserProfilePage.Role.MANAGER_RADIO_BUTTON)))),

            new DataBind<>(ViewUserProfilePage.class, UserLanguage.class, new LinkedList<>(Arrays.asList(
                    ImmutableMap.of("option", EditUserProfilePage.Language.DEUTSCH_OPTION),
                    ImmutableMap.of("option", EditUserProfilePage.Language.ENGLISH_OPTION),
                    ImmutableMap.of("option", EditUserProfilePage.Language.ESPANOL_OPTION),
                    ImmutableMap.of("option", EditUserProfilePage.Language.FRANCAIS_OPTION),
                    ImmutableMap.of("option", EditUserProfilePage.Language.ITALIANO_OPTION),
                    ImmutableMap.of("option", EditUserProfilePage.Language.NEDERLANDS_OPTION),
                    ImmutableMap.of("option", EditUserProfilePage.Language.NORSK_OPTION),
                    ImmutableMap.of("option", EditUserProfilePage.Language.POLSKI_OPTION))))
    ));
}
