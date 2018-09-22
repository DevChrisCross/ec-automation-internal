package com.elavon.binder;

import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Binder {

    public static Map<Class<? extends PageObject>, Map<Bindable, Map<?, ?>>> bindMap;

    public static <K, V> void bindObjects(DataBind<K, V> dataBind) {
        Map<Bindable, Map<?, ?>> targetMap = bindMap.get(dataBind.getPageClass());
        Bindable[] enumConstants = dataBind.getBindClass().getEnumConstants();
        Queue<Map<K, V>> data = dataBind.getData();

        for (Bindable bindable : enumConstants) {
            targetMap.put(bindable, data.poll());
        }
    }

    public static Map<Bindable, Map<?, ?>> bindMapOf(Class<? extends PageObject> page) {
        return bindMap.get(page);
    }

    public static void loadBinders() {
        PageBind.pages.forEach(clazz -> bindMap.put(clazz, new HashMap<>()));
        PageBind.dataBinds.forEach(Binder::bindObjects);
    }
}
