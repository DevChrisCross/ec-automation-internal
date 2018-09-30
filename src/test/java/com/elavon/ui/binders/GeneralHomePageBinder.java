package com.elavon.ui.binders;

import com.elavon.binder.Bindable;
import com.elavon.binder.DataBind;
import com.elavon.constants.HomeNavigation;
import com.elavon.ui.pages.GeneralHomePage;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.LinkedList;

import static com.elavon.binder.PageBind.*;
import static com.elavon.ui.pages.GeneralHomePage.*;

public class GeneralHomePageBinder implements Bindable {

    @Override
    public DataBind<String, Target> retrieveData() {
        return new DataBind<>(
                DEFAULT_KEY,
                GeneralHomePage.class,
                ImmutableMap.of(HomeNavigation.class, new LinkedList<>(Arrays.asList(
                        defaultMap(TARGET_OF_NONE),
                        defaultMap(LOGIN_BUTTON),
                        defaultMap(CONTACT_US_BUTTON),
                        defaultMap(Footer.TERMS_OF_USE_LINK),
                        defaultMap(Footer.COOKIES_POLICY_LINK)))));
    }
}
