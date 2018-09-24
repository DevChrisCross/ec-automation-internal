package com.elavon.binder;

import com.elavon.constants.*;
import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.EditUserProfilePage;
import com.elavon.ui.pages.GeneralHomePage;
import com.elavon.ui.pages.ViewUserProfilePage;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import java.lang.reflect.Field;
import java.util.*;

public class PageBind {

    public static final String DEFAULT_KEY = "target";
    public static List<Class<? extends PageObject>> pages;
    public static List<DataBind<String, Target>> dataBinds;
    private static final Target TARGET_OF_NONE = Target.the("").locatedBy("");
    public static Map<Class<? extends PageObject>, BindMap<String, Target>> map = new HashMap<>();

    public static void loadBinders() {
        pages = new ArrayList<>(Arrays.asList(
                GeneralHomePage.class,
                CustomerSearchPage.class,
                ViewUserProfilePage.class
        ));

        dataBinds = new ArrayList<>(Arrays.asList(
                new DataBind<>(GeneralHomePage.class, HomeNavigation.class, new LinkedList<>(Arrays.asList(
                        defaultMap(TARGET_OF_NONE),
                        defaultMap(GeneralHomePage.LOGIN_BUTTON),
                        defaultMap(GeneralHomePage.CONTACT_US_BUTTON),
                        defaultMap(GeneralHomePage.Footer.TERMS_OF_USE_LINK),
                        defaultMap(GeneralHomePage.Footer.COOKIES_POLICY_LINK)))),

                new DataBind<>(CustomerSearchPage.class, SearchBy.class, new LinkedList<>(Arrays.asList(
                        defaultMap(CustomerSearchPage.LOCATION_TAB_BUTTON),
                        defaultMap(CustomerSearchPage.USER_TAB_BUTTON)))),

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
                        defaultMap(EditUserProfilePage.CUSTOMER_FIRST_NAME_FIELD),
                        defaultMap(EditUserProfilePage.CUSTOMER_LAST_NAME_FIELD),
                        defaultMap(EditUserProfilePage.CUSTOMER_EMAIL_FIELD),
                        defaultMap(EditUserProfilePage.Language.DROPDOWN),
                        defaultMap(TARGET_OF_NONE)))),

                new DataBind<>(ViewUserProfilePage.class, UserRole.class, new LinkedList<>(Arrays.asList(
                        defaultMap(EditUserProfilePage.Role.EMPLOYEE_RADIO_BUTTON),
                        defaultMap(EditUserProfilePage.Role.MANAGER_RADIO_BUTTON)))),

                new DataBind<>(ViewUserProfilePage.class, UserLanguage.class, new LinkedList<>(Arrays.asList(
                        defaultMap(EditUserProfilePage.Language.DEUTSCH_OPTION),
                        defaultMap(EditUserProfilePage.Language.ENGLISH_OPTION),
                        defaultMap(EditUserProfilePage.Language.ESPANOL_OPTION),
                        defaultMap(EditUserProfilePage.Language.FRANCAIS_OPTION),
                        defaultMap(EditUserProfilePage.Language.ITALIANO_OPTION),
                        defaultMap(EditUserProfilePage.Language.NEDERLANDS_OPTION),
                        defaultMap(EditUserProfilePage.Language.NORSK_OPTION),
                        defaultMap(EditUserProfilePage.Language.POLSKI_OPTION))))
        ));

        pages.forEach(aClazz -> map.put(aClazz, new BindMap<>(PageBind.DEFAULT_KEY)));
        dataBinds.forEach(PageBind::bindObjects);
        pages.forEach(aClass -> {
            try {
                Field field = aClass.getDeclaredField("bind");
                field.set(null, map.get(aClass));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private static Map<String, Target> defaultMap(Target target) {
        return ImmutableMap.of(DEFAULT_KEY, target);
    }

    public static void bindObjects(DataBind<String, Target> dataBind) {
        BindMap<String, Target> targetMap = map.get(dataBind.getPageClass());
        Bindable[] enumConstants = dataBind.getBindClass().getEnumConstants();
        Queue<Map<String, Target>> data = dataBind.getData();

        for (Bindable bindable : enumConstants) {
            targetMap.put(bindable, data.poll());
        }
    }
}
