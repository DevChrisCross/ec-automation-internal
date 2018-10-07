package com.elavon.binder;

import com.elavon.ui.binders.CustomerAccount.*;
import com.elavon.ui.binders.GeneralHomePageBinder;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PageBind {

    public static final String DEFAULT_KEY = "target";
    public static final Target TARGET_OF_NONE = Target.the("").locatedBy("");

    public static void loadBinders() {
        List<? extends Bindable> pageBinders;
        pageBinders = new ArrayList<>(Arrays.asList(
                new GeneralHomePageBinder(),
                new CustomerSearchPageBinder(),
                new EditCustomerProfilePageBinder(),
                new EditLocationsPageBinder(),
                new CloneCustomerPageBinder(),
                new EditReportsPageBinder()
        ));

        pageBinders.forEach(bindable -> {
            DataBind<String, Target> dataBind = bindable.retrieveData();
            try {
                Field field = dataBind.getPageClass().getDeclaredField("bind");
                field.set(null, dataBind);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public static Map<String, Target> defaultMap(Target target) {
        return ImmutableMap.of(DEFAULT_KEY, target);
    }

}
