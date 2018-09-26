package com.elavon.binder;

import com.elavon.constants.*;
import com.elavon.ui.pages.CustomerAccount.EditCustomerProfilePage;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.GeneralHomePage;
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
                EditCustomerProfilePage.class,
                EditLocationsPage.class
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

                new DataBind<>(EditCustomerProfilePage.class, UserProfile.class, new LinkedList<>(Arrays.asList(
                        defaultMap(EditCustomerProfilePage.CUSTOMER_FIRST_NAME_FIELD),
                        defaultMap(EditCustomerProfilePage.CUSTOMER_LAST_NAME_FIELD),
                        defaultMap(EditCustomerProfilePage.CUSTOMER_EMAIL_FIELD),
                        defaultMap(EditCustomerProfilePage.Language.DROPDOWN),
                        defaultMap(TARGET_OF_NONE)))),

                new DataBind<>(EditCustomerProfilePage.class, UserRole.class, new LinkedList<>(Arrays.asList(
                        defaultMap(EditCustomerProfilePage.Role.EMPLOYEE_RADIO_BUTTON),
                        defaultMap(EditCustomerProfilePage.Role.MANAGER_RADIO_BUTTON)))),

                new DataBind<>(EditCustomerProfilePage.class, UserLanguage.class, new LinkedList<>(Arrays.asList(
                        defaultMap(EditCustomerProfilePage.Language.DEUTSCH_OPTION),
                        defaultMap(EditCustomerProfilePage.Language.ENGLISH_OPTION),
                        defaultMap(EditCustomerProfilePage.Language.ESPANOL_OPTION),
                        defaultMap(EditCustomerProfilePage.Language.FRANCAIS_OPTION),
                        defaultMap(EditCustomerProfilePage.Language.ITALIANO_OPTION),
                        defaultMap(EditCustomerProfilePage.Language.NEDERLANDS_OPTION),
                        defaultMap(EditCustomerProfilePage.Language.NORSK_OPTION),
                        defaultMap(EditCustomerProfilePage.Language.POLSKI_OPTION)))),

                new DataBind<>(EditLocationsPage.class, UserLocationRule.class, new LinkedList<>(Arrays.asList(
                        defaultMap(EditLocationsPage.Location.RULE_MID_OPTION),
                        defaultMap(EditLocationsPage.Location.RULE_CHAIN_OPTION),
                        defaultMap(EditLocationsPage.Location.RULE_ENTITY_OPTION)
                )))
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
