package com.elavon.binder;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import java.util.Map;
import java.util.Queue;

public class Binder {

    public static Map<Class<? extends PageObject>, BindMap<String, Target>> map;

    public static void loadBinders() {
        PageBind.pages.forEach(clazz -> map.put(clazz, new BindMap<>(PageBind.DEFAULT_KEY)));
        PageBind.dataBinds.forEach(Binder::bindObjects);
    }

    public static void bindObjects(DataBind<String, Target> dataBind) {
        BindMap<String, Target> targetMap = map.get(dataBind.getPageClass());
        Bindable[] enumConstants = dataBind.getBindClass().getEnumConstants();
        Queue<Map<String, Target>> data = dataBind.getData();

        for (Bindable bindable : enumConstants) {
            targetMap.put(bindable, data.poll());
        }
    }

    public static BindMap<String, Target> bindMapOf(Class<? extends PageObject> page) {
        return map.get(page);
    }
}
