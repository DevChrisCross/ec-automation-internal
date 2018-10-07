package com.elavon.ui.binders.CustomerAccount;

import com.elavon.binder.Bindable;
import com.elavon.binder.DataBind;
import com.elavon.constants.user.UserLocationRule;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.LinkedList;

import static com.elavon.binder.PageBind.DEFAULT_KEY;
import static com.elavon.binder.PageBind.defaultMap;
import static com.elavon.ui.pages.CustomerAccount.EditLocationsPage.Location;

public class EditLocationsPageBinder implements Bindable {

    @Override
    public DataBind<String, Target> retrieveData() {
        return new DataBind<>(
                DEFAULT_KEY,
                EditLocationsPage.class,
                ImmutableMap.of(UserLocationRule.class, new LinkedList<>(Arrays.asList(
                        defaultMap(Location.RULE_MID_OPTION),
                        defaultMap(Location.RULE_CHAIN_OPTION),
                        defaultMap(Location.RULE_ENTITY_OPTION)))));
    }
}
