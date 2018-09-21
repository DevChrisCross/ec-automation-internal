package com.elavon.binder;

import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.HomePage;
import com.elavon.ui.pages.UserProfilePage;
import net.thucydides.core.pages.PageObject;

import java.util.*;

public class Binder {

    public static Map<Class<? extends PageObject>, Map<Bindable, Map<?, ?>>> bindMap;
    public static List<Class<? extends PageObject>> bindList = new ArrayList<>(Arrays.asList(
            HomePage.class,
            CustomerSearchPage.class,
            UserProfilePage.class
    ));

    public static <K, V> void bindObjects(DataBind<K, V> dataBind) {
        Map<Bindable, Map<?, ?>> targetMap = bindMap.get(dataBind.getPageClass());
        Bindable[] enumConstants = dataBind.getBindClass().getEnumConstants();
        Queue<Map<K, V>> data = dataBind.getData();

        for (Bindable bindable : enumConstants) {
            targetMap.put(bindable, data.poll());
        }
    }

    public static Map<Bindable, Map<?, ?>> mapOf(Class<? extends PageObject> page) {
        return bindMap.get(page);
    }

    public static void loadBinders() {
        bindList.forEach(clazz -> {
            bindMap.put(clazz, new HashMap<>());
        });
        PageBind.bindList.forEach(Binder::bindObjects);
    }
}
