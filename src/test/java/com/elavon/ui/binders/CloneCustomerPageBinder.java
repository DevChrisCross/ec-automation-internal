package com.elavon.ui.binders;

import com.elavon.binder.Bindable;
import com.elavon.binder.DataBind;
import com.elavon.constants.UserLanguage;
import com.elavon.constants.UserRole;
import com.elavon.ui.pages.CustomerAccount.CloneCustomerPage;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.LinkedList;

import static com.elavon.binder.PageBind.DEFAULT_KEY;
import static com.elavon.binder.PageBind.defaultMap;
import static com.elavon.ui.pages.CustomerAccount.CloneCustomerPage.Role;
import static com.elavon.ui.pages.CustomerAccount.EditCustomerProfilePage.Language;

public class CloneCustomerPageBinder implements Bindable {

    @Override
    public DataBind<String, Target> retrieveData() {
        return new DataBind<>(
                DEFAULT_KEY,
                CloneCustomerPage.class,
                ImmutableMap.of(
                        UserLanguage.class, new LinkedList<>(Arrays.asList(
                                defaultMap(Language.DEUTSCH_OPTION),
                                defaultMap(Language.ENGLISH_OPTION),
                                defaultMap(Language.ESPANOL_OPTION),
                                defaultMap(Language.FRANCAIS_OPTION),
                                defaultMap(Language.ITALIANO_OPTION),
                                defaultMap(Language.NEDERLANDS_OPTION),
                                defaultMap(Language.NORSK_OPTION),
                                defaultMap(Language.POLSKI_OPTION))),

                        UserRole.class, new LinkedList<>(Arrays.asList(
                                defaultMap(Role.EMPLOYEE_RADIO_BUTTON),
                                defaultMap(Role.MANAGER_RADIO_BUTTON),
                                defaultMap(Role.PARTNER_USER_RADIO_BUTTON)))));
    }
}
