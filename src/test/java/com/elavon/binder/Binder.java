package com.elavon.binder;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Binder {

    public static Map<Class<? extends PageObject>, Map<Bindable, Map<String, Target>>> bindMap;

    public static void bindObjects(DataBind<String, Target> dataBind) {
        Map<Bindable, Map<String, Target>> targetMap = bindMap.get(dataBind.getPageClass());
        Bindable[] enumConstants = dataBind.getBindClass().getEnumConstants();
        Queue<Map<String, Target>> data = dataBind.getData();

        for (Bindable bindable : enumConstants) {
            targetMap.put(bindable, data.poll());
        }
    }

    public static Map<Bindable, Map<String, Target>> bindMapOf(Class<? extends PageObject> page) {
        return bindMap.get(page);
    }

    public static void loadBinders() {
        PageBind.pages.forEach(clazz -> bindMap.put(clazz, new HashMap<>()));
        PageBind.dataBinds.forEach(Binder::bindObjects);
    }
}
