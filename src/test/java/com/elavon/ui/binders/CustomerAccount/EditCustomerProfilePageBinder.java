package com.elavon.ui.binders.CustomerAccount;

import com.elavon.binder.Bindable;
import com.elavon.binder.DataBind;
import com.elavon.constants.user.UserLanguage;
import com.elavon.constants.user.UserProfile;
import com.elavon.constants.user.UserRole;
import com.elavon.ui.pages.CustomerAccount.EditCustomerProfilePage;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.LinkedList;

import static com.elavon.binder.PageBind.*;
import static com.elavon.ui.pages.CustomerAccount.EditCustomerProfilePage.*;

public class EditCustomerProfilePageBinder implements Bindable {

    @Override
    public DataBind<String, Target> retrieveData() {
        return new DataBind<>(
                DEFAULT_KEY,
                EditCustomerProfilePage.class,
                ImmutableMap.of(
                        UserProfile.class, new LinkedList<>(Arrays.asList(
                                defaultMap(FIRST_NAME_FIELD),
                                defaultMap(LAST_NAME_FIELD),
                                defaultMap(EMAIL_FIELD),
                                defaultMap(LANGUAGE_DROPDOWN),
                                defaultMap(TARGET_OF_NONE))),

                        UserRole.class, new LinkedList<>(Arrays.asList(
                                defaultMap(Role.EMPLOYEE_RADIO_BUTTON),
                                defaultMap(Role.MANAGER_RADIO_BUTTON),
                                defaultMap(TARGET_OF_NONE))),

                        UserLanguage.class, new LinkedList<>(Arrays.asList(
                                defaultMap(Language.DEUTSCH_OPTION),
                                defaultMap(Language.ENGLISH_OPTION),
                                defaultMap(Language.ESPANOL_OPTION),
                                defaultMap(Language.FRANCAIS_OPTION),
                                defaultMap(Language.ITALIANO_OPTION),
                                defaultMap(Language.NEDERLANDS_OPTION),
                                defaultMap(Language.NORSK_OPTION),
                                defaultMap(Language.POLSKI_OPTION)))));
    }
}
