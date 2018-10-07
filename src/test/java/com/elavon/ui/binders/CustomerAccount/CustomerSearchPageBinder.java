package com.elavon.ui.binders.CustomerAccount;

import com.elavon.binder.Bindable;
import com.elavon.binder.DataBind;
import com.elavon.constants.search.SearchBy;
import com.elavon.constants.search.SearchFilter;
import com.elavon.ui.pages.CustomerSearchPage;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.LinkedList;

import static com.elavon.binder.PageBind.DEFAULT_KEY;
import static com.elavon.binder.PageBind.defaultMap;
import static com.elavon.ui.pages.CustomerSearchPage.*;

public class CustomerSearchPageBinder implements Bindable {

    @Override
    public DataBind<String, Target> retrieveData() {
        return new DataBind<>(
                DEFAULT_KEY,
                CustomerSearchPage.class,
                ImmutableMap.of(
                        SearchBy.class, new LinkedList<>(Arrays.asList(
                                defaultMap(LOCATION_TAB_BUTTON),
                                defaultMap(USER_TAB_BUTTON))),

                        SearchFilter.class, new LinkedList<>(Arrays.asList(
                                ImmutableMap.of("option", Filter.GROUP_DROPDOWN_OPTION,
                                        "field", Filter.GROUP_FIELD),
                                ImmutableMap.of("option", Filter.ENTITY_DROPDOWN_OPTION,
                                        "field", Filter.ENTITY_FIELD),
                                ImmutableMap.of("option", Filter.MCC_DROPDOWN_OPTION,
                                        "field", Filter.MCC_FIELD),
                                ImmutableMap.of("option", Filter.MERCHANT_ID_DROPDOWN_OPTION,
                                        "field", Filter.MERCHANT_ID_FIELD),
                                ImmutableMap.of("option", Filter.NAME_DROPDOWN_OPTION,
                                        "field", Filter.FIRST_NAME_FIELD),
                                ImmutableMap.of("option", Filter.NAME_DROPDOWN_OPTION,
                                        "field", Filter.LAST_NAME_FIELD),
                                ImmutableMap.of("option", Filter.TAX_ID_DROPDOWN_OPTION,
                                        "field", Filter.TAX_ID_FIELD),
                                ImmutableMap.of("option", Filter.EMAIL_DROPDOWN_OPTION,
                                        "field", Filter.EMAIL_FIELD),
                                ImmutableMap.of("option", Filter.USER_ID_DROPDOWN_OPTION,
                                        "field", Filter.USER_ID_FIELD)))));
    }
}
